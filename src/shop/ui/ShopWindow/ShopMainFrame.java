package shop.ui.ShopWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import shop.ui.Helper.PressableButton;

public class ShopMainFrame extends JFrame {

    // ================= RESIZE SETTINGS =================

    private static final int RESIZE_MARGIN = 10;

    private static final int MIN_WIDTH = 900;

    private static final int MIN_HEIGHT = 600;

    // ================= RESIZE VARIABLES =================

    private Point clickPoint;

    private int resizeDirection = 0;

    // ================= RESIZE DIRECTIONS =================

    private static final int NONE = 0;

    private static final int NORTH = 1;

    private static final int SOUTH = 2;

    private static final int WEST = 3;

    private static final int EAST = 4;

    private static final int NORTH_WEST = 5;

    private static final int NORTH_EAST = 6;

    private static final int SOUTH_WEST = 7;

    private static final int SOUTH_EAST = 8;

    public ShopMainFrame() {

        initializeFrame();

        JPanel topBar = createTopBar();

        add(topBar, BorderLayout.NORTH);

        add(new ShopWindow(), BorderLayout.CENTER);

        enableDragging(topBar);

        enableResizing();

        setVisible(true);
    }

    // ================= FRAME =================

    private void initializeFrame() {

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource(
                                "/images/logo.png"
                        )
                );

        setIconImage(icon.getImage());

        setTitle("AMAZON SHOP");

        setSize(1200, 800);

        setMinimumSize(
                new Dimension(
                        MIN_WIDTH,
                        MIN_HEIGHT
                )
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUndecorated(true);

        setLayout(new BorderLayout());
    }

    // ================= TOP BAR =================

    private JPanel createTopBar() {

        JPanel topBar =
                new JPanel(
                        new BorderLayout()
                );

        topBar.setBackground(
                Color.decode("#1e2020")
        );

        topBar.setPreferredSize(
                new Dimension(0, 40)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel("  AMAZON SHOP");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        topBar.add(title, BorderLayout.WEST);

        // ================= BUTTONS =================

        JPanel buttonsPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                5,
                                5
                        )
                );

        buttonsPanel.setOpaque(false);

        // MINIMIZE

        PressableButton minimize =
                createWindowButton(
                        "\u2014",
                        "#1e2020",
                        "#101312"
                );

        minimize.addActionListener(
                e -> setState(JFrame.ICONIFIED)
        );

        // MAXIMIZE

        PressableButton maximize =
                createWindowButton(
                        "□",
                        "#1e2020",
                        "#101312"
                );

                maximize.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )

        );
        maximize.addActionListener(e -> {

            if (getExtendedState()
                    == JFrame.MAXIMIZED_BOTH) {

                setExtendedState(JFrame.NORMAL);

            } else {

                setExtendedState(
                        JFrame.MAXIMIZED_BOTH
                );
            }
        });

        // CLOSE

        PressableButton close =
                createWindowButton(
                        "X",
                        "#1e2020",
                        "#ef4444"
                );

        close.addActionListener(
                e -> dispose()
        );

        buttonsPanel.add(minimize);

        buttonsPanel.add(maximize);

        buttonsPanel.add(close);

        topBar.add(
                buttonsPanel,
                BorderLayout.EAST
        );

        return topBar;
    }

    // ================= WINDOW BUTTON =================

    private PressableButton createWindowButton(
            String text,
            String normalColor,
            String pressedColor
    ) {

        PressableButton button =
                new PressableButton(
                        normalColor,
                        pressedColor,
                        10
                );

        button.setText(text);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        button.setPreferredSize(
                new Dimension(45, 25)
        );

        button.setFocusable(false);

        return button;
    }

    // ================= WINDOW DRAG =================

    private void enableDragging(JPanel topBar) {

        final Point[] mousePoint = {null};

        topBar.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {

                        mousePoint[0] =
                                e.getPoint();
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (e.getClickCount() == 2) {

                            if (getExtendedState()
                                    == JFrame.MAXIMIZED_BOTH) {

                                setExtendedState(
                                        JFrame.NORMAL
                                );

                            } else {

                                setExtendedState(
                                        JFrame.MAXIMIZED_BOTH
                                );
                            }
                        }
                    }
                });

        topBar.addMouseMotionListener(
                new MouseMotionAdapter() {

                    @Override
                    public void mouseDragged(MouseEvent e) {

                        if (getExtendedState()
                                == JFrame.MAXIMIZED_BOTH) {
                            return;
                        }

                        Point current =
                                e.getLocationOnScreen();

                        setLocation(
                                current.x - mousePoint[0].x,
                                current.y - mousePoint[0].y
                        );
                    }
                });
    }

    // ================= WINDOW RESIZE =================

    private void enableResizing() {

        MouseAdapter resizeListener =
                new MouseAdapter() {

                    @Override
                    public void mouseMoved(MouseEvent e) {

                        Point p =
                                SwingUtilities.convertPoint(
                                        e.getComponent(),
                                        e.getPoint(),
                                        ShopMainFrame.this
                                );

                        updateResizeCursor(p);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        clickPoint =
                                e.getLocationOnScreen();
                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {

                        if (getExtendedState()
                                == JFrame.MAXIMIZED_BOTH) {
                            return;
                        }

                        resizeWindow(
                                e.getLocationOnScreen()
                        );
                    }
                };

        addResizeListenerRecursively(
                getContentPane(),
                resizeListener
        );
    }

    // ================= UPDATE CURSOR =================

    private void updateResizeCursor(Point p) {

        int width = getWidth();

        int height = getHeight();

        boolean left =
                p.x <= RESIZE_MARGIN;

        boolean right =
                p.x >= width - RESIZE_MARGIN;

        boolean top =
                p.y <= RESIZE_MARGIN;

        boolean bottom =
                p.y >= height - RESIZE_MARGIN;

        resizeDirection = NONE;

        // CORNERS

        if (top && left) {

            resizeDirection = NORTH_WEST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.NW_RESIZE_CURSOR
                    )
            );
        }

        else if (top && right) {

            resizeDirection = NORTH_EAST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.NE_RESIZE_CURSOR
                    )
            );
        }

        else if (bottom && left) {

            resizeDirection = SOUTH_WEST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.SW_RESIZE_CURSOR
                    )
            );
        }

        else if (bottom && right) {

            resizeDirection = SOUTH_EAST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.SE_RESIZE_CURSOR
                    )
            );
        }

        // SIDES

        else if (left) {

            resizeDirection = WEST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.W_RESIZE_CURSOR
                    )
            );
        }

        else if (right) {

            resizeDirection = EAST;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.E_RESIZE_CURSOR
                    )
            );
        }

        else if (top) {

            resizeDirection = NORTH;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.N_RESIZE_CURSOR
                    )
            );
        }

        else if (bottom) {

            resizeDirection = SOUTH;

            setCursor(
                    Cursor.getPredefinedCursor(
                            Cursor.S_RESIZE_CURSOR
                    )
            );
        }

        else {

            setCursor(
                    Cursor.getDefaultCursor()
            );
        }
    }

    // ================= RESIZE WINDOW =================

    private void resizeWindow(Point dragPoint) {

        Rectangle bounds =
                getBounds();

        int dx =
                dragPoint.x - clickPoint.x;

        int dy =
                dragPoint.y - clickPoint.y;

        switch (resizeDirection) {

            case EAST:

                bounds.width =
                        Math.max(
                                MIN_WIDTH,
                                bounds.width + dx
                        );

                break;

            case SOUTH:

                bounds.height =
                        Math.max(
                                MIN_HEIGHT,
                                bounds.height + dy
                        );

                break;

            case WEST:

                if (bounds.width - dx >= MIN_WIDTH) {

                    bounds.x += dx;

                    bounds.width -= dx;
                }

                break;

            case NORTH:

                if (bounds.height - dy >= MIN_HEIGHT) {

                    bounds.y += dy;

                    bounds.height -= dy;
                }

                break;

            case NORTH_WEST:

                if (bounds.width - dx >= MIN_WIDTH) {

                    bounds.x += dx;

                    bounds.width -= dx;
                }

                if (bounds.height - dy >= MIN_HEIGHT) {

                    bounds.y += dy;

                    bounds.height -= dy;
                }

                break;

            case NORTH_EAST:

                bounds.width =
                        Math.max(
                                MIN_WIDTH,
                                bounds.width + dx
                        );

                if (bounds.height - dy >= MIN_HEIGHT) {

                    bounds.y += dy;

                    bounds.height -= dy;
                }

                break;

            case SOUTH_WEST:

                if (bounds.width - dx >= MIN_WIDTH) {

                    bounds.x += dx;

                    bounds.width -= dx;
                }

                bounds.height =
                        Math.max(
                                MIN_HEIGHT,
                                bounds.height + dy
                        );

                break;

            case SOUTH_EAST:

                bounds.width =
                        Math.max(
                                MIN_WIDTH,
                                bounds.width + dx
                        );

                bounds.height =
                        Math.max(
                                MIN_HEIGHT,
                                bounds.height + dy
                        );

                break;
        }

        setBounds(bounds);

        clickPoint = dragPoint;
    }

    // ================= ADD LISTENERS RECURSIVELY =================

    private void addResizeListenerRecursively(
            Component component,
            MouseAdapter listener
    ) {

        component.addMouseListener(listener);

        component.addMouseMotionListener(listener);

        if (component instanceof Container) {

            for (Component child :
                    ((Container) component)
                            .getComponents()) {

                addResizeListenerRecursively(
                        child,
                        listener
                );
            }
        }
    }
}