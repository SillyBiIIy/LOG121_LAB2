import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Command.*;
import controleur.*;


    public class ImageZoomExample extends JPanel {
        private BufferedImage image;
        private double scale = 1.0; // Initial scale factor
        private int xOffset = 0;
        private int yOffset = 0;
        private Translation translator = new Translation();

        public ImageZoomExample(BufferedImage image) {
            this.image = image;

            // Add mouse wheel listener for zooming
            addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    int notches = e.getWheelRotation();

                    if (notches < 0) {
                        //set command to zoom in
                    } else {
                        //set command to zoom out
                    }
                    repaint();
                }
            });

            // Add mouse drag listener for panning
            addMouseMotionListener(new MouseAdapter() {
                private int lastX, lastY;

                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();
                    System.out.println("Mouse Clicked: " + e.getX() + ":" + e.getY());
                    //set delta of translation
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("MOUSE RELEASED");
                    //potentially reset flag for delta setting
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    //set Command to translation
                    Point offset = new Point(translator.translationCommand(new Point(e.getX(),e.getY())));
                    xOffset=offset.x;
                    yOffset=offset.y;
                    repaint();

                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.scale(scale, scale);
            g2d.drawImage(image, xOffset, yOffset, this);
            g2d.dispose();
        }

        public static void main(String[] args) {
            //Create Commands
            Command translation = new Translation();
            Command ZoomIn = new ZoomIn();
            Command ZoomOut = new ZoomOut();
            Command Undo = new Undo();

            //get Command Controller
            GestionnaireCommande gComm = GestionnaireCommande.getInstance();


            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame("Image Zoom Example");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    try {
                        // Load an image (you can replace this with your image)
                        BufferedImage image = ImageIO.read(new File("C:\\Users\\gaspa\\Documents\\Ducks\\IMG-7092.jpg"));
                        ImageZoomExample zoomExample = new ImageZoomExample(image);
                        frame.add(zoomExample);

                        frame.setSize(800, 600);
                        frame.setVisible(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


