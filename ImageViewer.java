import cs180.image.Image;
import cs180.image.Pixel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Image Viewer GUI
 *
 * @author Joseph Lewis joseph@josephlewis.net
 * @version 2/25/16
 */
public class ImageViewer extends JFrame {

    private JLabel label = new JLabel();

    private Image myImage;
    private final EffectsList effects;

    /**
     * Image viewer created from a list of effects and the
     * path to the image
     * @param effects list of effects
     * @param myImagePath path to the image
     */
    public ImageViewer(EffectsList effects, String myImagePath) {
        this.myImage = new cs180.image.Image(myImagePath);
        this.effects = effects;

        // Set window information
        setTitle("180shop");
        setSize(640, 480);
        setLocationRelativeTo(null);

        // Exit the program when the main window is closed.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up the main menu.
        setupMainMenu();

        updateImage();

        // Pack everything together and add it
        add(new JScrollPane(label), BorderLayout.CENTER);
        setVisible(true);

    }

    /**
     * Get menu of available effects from effect list
     * @return menu
     */
    private JMenu getEffectsMenu() {
        JMenu menu = new JMenu("Effects");

        for (String name : effects.getEffectNames()) {
            JMenuItem menuItem = new JMenuItem(name);

            menuItem.addActionListener((e) -> {
                effects.runEffect(name, myImage);
                updateImage();
            });

            menu.add(menuItem);
        }

        return menu;

    }

    /**
     * Create a main menu
     */
    private void setupMainMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu m = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener((event) -> openImage());
        m.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save As...");
        saveItem.addActionListener((event) -> saveImage());
        m.add(saveItem);

        mbar.add(m);
        mbar.add(getEffectsMenu());

        setJMenuBar(mbar);
    }

    /**
     * Create a chooser for other images
     * @return file chooser
     */
    private JFileChooser getImageChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".jpg") || f.isDirectory();
            }

            public String getDescription() {
                return "jpg Images";
            }
        });
        return chooser;
    }

    /**
     * Open the image in the viewer
     */
    private void openImage() {
        JFileChooser chooser = getImageChooser();

        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getPath();
            myImage = new cs180.image.Image(path);

            updateImage();
        }
    }

    /**
     * Save the image
     */
    private void saveImage() {
        JFileChooser chooser = getImageChooser();

        int r = chooser.showSaveDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getPath();
            if (!path.toLowerCase().endsWith(".jpg")) {
                path += ".jpg";
            }
            File outputfile = new File(path);
            try {
                ImageIO.write(myImage.getImageData(), "jpg", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            updateImage();
        }
    }

    /**
     * Update the image
     */
    private void updateImage() {
        label.setIcon(new ImageIcon(myImage.getImageData()));

        this.repaint();
        this.revalidate();
        label.repaint();
    }

}






