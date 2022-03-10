import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class CreatieInterface extends JFrame {


    JFrame f;
    JPanel loginPanel;
    JPanel mainPenal;
    JPanel menuPenal;
    JPanel buttonmenuPenal;
    JPanel workspacePanal;
    //------
    JButton categorieFilmButton;
    JButton clientButton;
    //SALA--------------
    JButton salaButton;
    JButton addSala;
    JButton showSala;
    JButton deleteSala;
    JButton findSala;
    JButton lovSala;
    JButton detailByNume;
    JPanel salaButtons;
    JPanel salaWork;
    //----------
    //Cinema---------------
    JButton cinemaButton;
    JButton addCinema;
    JButton showCinema;
    JButton deleteCinema;
    JButton incaCinema;
    JButton cliCinema;
    JButton fiByCinema;
    JButton ciByCinema;
    JPanel cinemaButtons;
    JPanel cinemaWork;
    //------------------------
    //Film----------------------
    JButton filmButton;
    JButton addFilm;
    JButton showFilm;
    JButton deleteFilm;
    JButton filmBi;
    JButton numbLimba;
    JButton choFi;
    JPanel filmButtons;
    JPanel filmWork;
    //--------------------
    JPanel categorieButtons;
    JPanel categorieWorkSpace;
    JPanel clientButtons;
    JPanel clientWorkSpace;
    //log in page
    JPanel titleLogIn;
    JPanel menuLogIn;
    JPanel workspaseLogIn;


    //-----


    JButton register;
    JButton logIn;
    //----------------Categorie
    JButton addButton;
    JButton showButton;
    JButton deleteButton;
    JButton updateButton;
    JButton ficaButton;
    //---------------------------------
    JButton addButtonC;
    JButton showButtonC;
    JButton deleteButtonC;


    Connection connection;

    public CreatieInterface(Connection connection) {
        this.connection = connection;
    }

    public static void errorMessage(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void start() {
        f = new JFrame("CinemaCItyBuric");

        f.setLayout(new BorderLayout());
        f.setSize(new Dimension(1000, 700));


        //----
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;


        //----
        mainPenal = new JPanel();
        menuPenal = new JPanel();
        buttonmenuPenal = new JPanel();
        workspacePanal = new JPanel();
        categorieButtons = new JPanel();
        categorieWorkSpace = new JPanel();
        titleLogIn = new JPanel();
        menuLogIn = new JPanel();
        workspaseLogIn = new JPanel();


        //-----
        loginPanel = new JPanel();

        register = new JButton();
        logIn = new JButton();

        register.setText("Register");
        logIn.setText("Log In");


        titleLogIn.setBackground(new java.awt.Color(255, 204, 51));
        menuLogIn.setBackground(new java.awt.Color(255, 204, 102));
        workspaseLogIn.setBackground(Color.yellow);

        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);


        int k = menuLogIn.getHeight();
        menuLogIn.setPreferredSize(new Dimension(150, k));
        int h = workspaseLogIn.getWidth();
        workspaseLogIn.setPreferredSize(new Dimension(h, 690));
        //----
        loginPanelLayout.setHorizontalGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(titleLogIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(loginPanelLayout.createSequentialGroup().addComponent(menuLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(workspaseLogIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        loginPanelLayout.setVerticalGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(loginPanelLayout.createSequentialGroup().addComponent(titleLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(menuLogIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(loginPanelLayout.createSequentialGroup().addComponent(workspaseLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))));

        //---------menu log in
        JLabel jLabel1 = new JLabel();
        jLabel1.setText("Cinema City Buric");

        GroupLayout titleLogInLayout = new GroupLayout(titleLogIn);
        titleLogIn.setLayout(titleLogInLayout);

        titleLogInLayout.setHorizontalGroup(titleLogInLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(titleLogInLayout.createSequentialGroup().addGap(168, 168, 168).addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE).addContainerGap(164, Short.MAX_VALUE)));
        titleLogInLayout.setVerticalGroup(titleLogInLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, titleLogInLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE).addContainerGap()));

        GroupLayout menuLogInLayout = new GroupLayout(menuLogIn);
        menuLogIn.setLayout(menuLogInLayout);


        menuLogInLayout.setHorizontalGroup(menuLogInLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(menuLogInLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(menuLogInLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(register, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(logIn, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        menuLogInLayout.setVerticalGroup(menuLogInLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(menuLogInLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(register).addGap(45, 45, 45).addComponent(logIn).addContainerGap(136, Short.MAX_VALUE)));

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workspaseLogIn.removeAll();
                workspaseLogIn.revalidate();
                workspaseLogIn.repaint();

                workspaseLogIn.setLayout(new GridBagLayout());

                //USERNAME
                JLabel username = new JLabel("Username:    ");
                JTextField usernameText = new JTextField(15);

                //PASSWORDD
                JLabel password = new JLabel("Password:    ");
                JTextField passwordText = new JPasswordField(15);

                JButton REGISTER = new JButton("Register");


                REGISTER.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameText.getText();
                        System.out.println("Username: " + username);
                        String password = passwordText.getText();
                        System.out.println("Password: " + password);
                        UsersMan usersMan = new UsersMan(connection);
                        try {
                            usersMan.addCredentials(username, password);
                            errorMessage("User adaugat cu success", "Adaugare User");


                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                c.gridx = 0;
                c.gridy = 0;
                workspaseLogIn.add(username, c);
                c.gridx = 1;
                c.gridy = 0;
                workspaseLogIn.add(usernameText, c);
                c.gridx = 0;
                c.gridy = 1;
                workspaseLogIn.add(password, c);
                c.gridx = 1;
                c.gridy = 1;
                workspaseLogIn.add(passwordText, c);
                c.gridx = 0;
                c.gridy = 2;
                workspaseLogIn.add(REGISTER, c);
                workspaseLogIn.invalidate();
                workspaseLogIn.validate();


            }
        });

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspaseLogIn.removeAll();
                workspaseLogIn.revalidate();
                workspaseLogIn.repaint();

                workspaseLogIn.setLayout(new GridBagLayout());

                //USERNAME
                JLabel username = new JLabel("Username:    ");
                JTextField usernameText = new JTextField(15);

                //PASSWORDD
                JLabel password = new JLabel("Password:    ");
                JTextField passwordText = new JPasswordField(15);

                JButton LOGIN = new JButton("Log in");


                LOGIN.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameText.getText();
                        System.out.println("Username: " + username);
                        String password = passwordText.getText();
                        System.out.println("Password: " + password);
                        UsersMan usersMan = new UsersMan(connection);
                        try {
                            if (usersMan.checkCredentials(username, password)) {
                                System.out.println("Good");
                                //Ar trebui sa punem panelul de main
                                f.setContentPane(mainPenal);
                                f.invalidate();
                                f.validate();
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                c.gridx = 0;
                c.gridy = 0;
                workspaseLogIn.add(username, c);
                c.gridx = 1;
                c.gridy = 0;
                workspaseLogIn.add(usernameText, c);
                c.gridx = 0;
                c.gridy = 1;
                workspaseLogIn.add(password, c);
                c.gridx = 1;
                c.gridy = 1;
                workspaseLogIn.add(passwordText, c);
                c.gridx = 0;
                c.gridy = 2;
                workspaseLogIn.add(LOGIN, c);
                workspaseLogIn.invalidate();
                workspaseLogIn.validate();

            }
        });


        menuPenal.setBackground(new java.awt.Color(255, 204, 51));
        buttonmenuPenal.setBackground(new java.awt.Color(255, 204, 102));
        workspacePanal.setBackground(Color.BLUE);
        mainPenal.setBackground(Color.BLACK);

        //---BUTOANELE----------------------------------------------
        categorieFilmButton = new JButton();
        clientButton = new JButton();
        salaButton = new JButton();
        cinemaButton = new JButton();
        filmButton = new JButton();


        categorieFilmButton.setText("Categorie Film");
        clientButton.setText("Client");
        salaButton.setText("Sala");
        cinemaButton.setText("Cinema");
        filmButton.setText("Film");
        //----------------------------------------------------------------------


        GroupLayout mainPanelLayout = new GroupLayout(mainPenal);
        mainPenal.setLayout(mainPanelLayout);
        int i = buttonmenuPenal.getHeight();
        buttonmenuPenal.setPreferredSize(new Dimension(150, i));

        int j = workspacePanal.getWidth();
        workspacePanal.setPreferredSize(new Dimension(j, 690));


        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(menuPenal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(mainPanelLayout.createSequentialGroup().addComponent(buttonmenuPenal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(workspacePanal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addComponent(menuPenal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(buttonmenuPenal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(mainPanelLayout.createSequentialGroup().addComponent(workspacePanal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))));


        //-----------MENU

        GroupLayout menuPanelLayout = new GroupLayout(menuPenal);
        menuPenal.setLayout(menuPanelLayout);

        //----ADAUGARE BUTOANE---------------------------------------------
        menuPanelLayout.setHorizontalGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(menuPanelLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(categorieFilmButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(salaButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(cinemaButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(filmButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(49, 49, 49).addComponent(clientButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        menuPanelLayout.setVerticalGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(menuPanelLayout.createSequentialGroup().addGap(33, 33, 33).addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(categorieFilmButton).addComponent(salaButton).addComponent(cinemaButton).addComponent(filmButton).addComponent(clientButton)).addContainerGap(36, Short.MAX_VALUE)));
        //------------------Categorie-------------------------------------------------------

        addButton = new JButton();
        showButton = new JButton();
        deleteButton = new JButton();
        updateButton = new JButton();
        ficaButton = new JButton();

        addButton.setText("Addcf");

        showButton.setText("Showcf");

        deleteButton.setText("Deletecf");

        updateButton.setText("Updatecf");

        ficaButton.setText("Film Categorie");

        GroupLayout categorieButtonsLayout = new GroupLayout(categorieButtons);
        categorieButtons.setLayout(categorieButtonsLayout);


        GroupLayout categorieWorkSpaceLayout = new GroupLayout(categorieWorkSpace);
        categorieWorkSpace.setLayout(categorieWorkSpaceLayout);

        categorieFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                buttonmenuPenal.removeAll();
                buttonmenuPenal.revalidate();
                buttonmenuPenal.repaint();


                buttonmenuPenal.add(categorieButtons);
                buttonmenuPenal.invalidate();
                buttonmenuPenal.validate();

            }
        });

        categorieButtonsLayout.setHorizontalGroup(categorieButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(categorieButtonsLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(categorieButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(deleteButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(updateButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ficaButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        categorieButtonsLayout.setVerticalGroup(categorieButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(categorieButtonsLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(addButton).addGap(45, 45, 45).addComponent(showButton).addGap(45, 45, 45).addComponent(deleteButton).addGap(45, 45, 45).addComponent(updateButton).addGap(45, 45, 45).addComponent(ficaButton).addContainerGap(136, Short.MAX_VALUE)));

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorieWorkSpace.removeAll();
                categorieWorkSpace.revalidate();
                categorieWorkSpace.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                JLabel updateGenulFilmLabel = new JLabel("GenulFilm: ");
                JTextField updateGenulFilmLabelText = new JTextField();
                updateGenulFilmLabelText.setColumns(20);

                JLabel updateGenulFilmNewLabel = new JLabel("GenulFilmNew: ");
                JTextField updateGenulFilmNewLabelText = new JTextField();
                updateGenulFilmNewLabelText.setColumns(20);


                JButton updateButtonCF = new JButton("Update CF");
                updateButtonCF.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String gen = updateGenulFilmLabelText.getText();
                        String genNew = updateGenulFilmNewLabelText.getText();

                        CategorieFilmMan categorieFilmMan = new CategorieFilmMan(connection);


                        try {
                            int ok = categorieFilmMan.updateCategorie(gen, genNew);
                            if (ok == 1) {
                                errorMessage("Actualizat cu success", "Actualizare reusita");
                            } else {
                                errorMessage("Genul introdus nu exista in baza de date", "Actualizare esuata");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                categorieWorkSpace.add(updateGenulFilmLabel);
                categorieWorkSpace.add(updateGenulFilmLabelText);
                categorieWorkSpace.add(updateGenulFilmNewLabel);
                categorieWorkSpace.add(updateGenulFilmNewLabelText);
                categorieWorkSpace.add(updateButtonCF);


                workspacePanal.add(categorieWorkSpace);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorieWorkSpace.removeAll();
                categorieWorkSpace.revalidate();
                categorieWorkSpace.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                JLabel addGenulFilmLabel = new JLabel("GenulFilm: ");
                JTextField addGenulFilmLabelText = new JTextField();
                addGenulFilmLabelText.setColumns(20);

                JButton addButtonCF = new JButton("Add CF");
                addButtonCF.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String gen = addGenulFilmLabelText.getText();

                        CategorieFilmMan categorieFilmMan = new CategorieFilmMan(connection);
                        System.out.println(gen);


                        try {
                            categorieFilmMan.addCategorieFilm(gen);
                            errorMessage("Adaugat cu success", "Adaugare genul");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                categorieWorkSpace.add(addGenulFilmLabel);
                categorieWorkSpace.add(addGenulFilmLabelText);
                categorieWorkSpace.add(addButtonCF);


                workspacePanal.add(categorieWorkSpace);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CategorieFilmMan categorieFilmMan = new CategorieFilmMan(connection);

                categorieWorkSpace.removeAll();
                categorieWorkSpace.revalidate();
                categorieWorkSpace.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<CategorieFilm> categorieFilmList = categorieFilmMan.showAll();
                    categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("     GenulFilm     ");
                    JLabel separator = new JLabel("|-------------------|");

                    categorieWorkSpace.add(titleLabel);
                    categorieWorkSpace.add(separator);


                    for (CategorieFilm categorieFilm : categorieFilmList) {
                        JLabel docLabel = new JLabel(categorieFilm.getGenulFilm());
                        categorieWorkSpace.add(docLabel);
                    }

                    workspacePanal.add(categorieWorkSpace);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorieWorkSpace.removeAll();
                categorieWorkSpace.revalidate();
                categorieWorkSpace.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                JLabel addGenulFilmLabel = new JLabel("GenulFilm: ");
                JTextField addGenulFilmLabelText = new JTextField();
                addGenulFilmLabelText.setColumns(20);

                JButton addButtonCF = new JButton("Delete CF");
                addButtonCF.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String gen = addGenulFilmLabelText.getText();

                        CategorieFilmMan categorieFilmMan = new CategorieFilmMan(connection);


                        try {
                            categorieFilmMan.deleteCategorieFilm(gen);
                            errorMessage("Sters cu success", "Sters genul");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                categorieWorkSpace.add(addGenulFilmLabel);
                categorieWorkSpace.add(addGenulFilmLabelText);
                categorieWorkSpace.add(addButtonCF);


                workspacePanal.add(categorieWorkSpace);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });
        ficaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FilmMan filmMan = new FilmMan(connection);

                categorieWorkSpace.removeAll();
                categorieWorkSpace.revalidate();
                categorieWorkSpace.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Film> filmList = filmMan.showAll();
                    categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("DenumireFilm          DurataFilm            LimbaDifuzare                    DataAparitie                   Descriere  ");
                    JLabel separator = new JLabel("|-------------------------------------------------------------------------------------------------------------------------------------------|");

                    categorieWorkSpace.add(titleLabel);
                    categorieWorkSpace.add(separator);


                    for (Film film : filmList) {
                        JLabel docLabel = new JLabel(film.getDenumireFilm() + "                  " + film.getDurataFilm() + "                        " + film.getLimbaDifuzare() + "                                     " + film.getDataAparitie() + "                    " + film.getDescriere());
                        categorieWorkSpace.add(docLabel);
                    }

                    JLabel choosefILabel = new JLabel("Film: ");
                    JTextField choosefIText = new JTextField();
                    choosefIText.setColumns(20);
                    categorieWorkSpace.add(choosefILabel);
                    categorieWorkSpace.add(choosefIText);

                    JButton choosefIButtonCI = new JButton("Search");
                    categorieWorkSpace.add(choosefIButtonCI);

                    choosefIButtonCI.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            CategorieFilmMan catFiMan = new CategorieFilmMan(connection);

                            categorieWorkSpace.removeAll();
                            categorieWorkSpace.revalidate();
                            categorieWorkSpace.repaint();

                            workspacePanal.removeAll();
                            workspacePanal.revalidate();
                            workspacePanal.repaint();

                            try {
                                Map<String, String> filmMap = catFiMan.catwFi(choosefIText.getText());

                                categorieWorkSpace.setLayout(new BoxLayout(categorieWorkSpace, BoxLayout.Y_AXIS));

                                JLabel titleLabel = new JLabel("FILM                     CATEGORIE");
                                JLabel separator = new JLabel("|------------------------------------------------|");

                                categorieWorkSpace.add(titleLabel);
                                categorieWorkSpace.add(separator);

                                for (Map.Entry<String, String> entry : filmMap.entrySet()) {
                                    System.out.println(entry.getKey() + ":" + entry.getValue());
                                    JLabel docLabel = new JLabel(entry.getKey().substring(0, entry.getKey().length() - 2) + "                                       " + entry.getValue());
                                    categorieWorkSpace.add(docLabel);
                                }

                                workspacePanal.add(categorieWorkSpace);
                                workspacePanal.invalidate();
                                workspacePanal.validate();

                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }


                        }
                    });

                    workspacePanal.add(categorieWorkSpace);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        //-----------------------------------------------------------------

        //Client buton----------------------------------------------------------
        clientButtons = new JPanel();
        clientWorkSpace = new JPanel();
        addButtonC = new JButton();
        showButtonC = new JButton();
        deleteButtonC = new JButton();

        addButtonC.setText("Addc");
        showButtonC.setText("Showc");
        deleteButtonC.setText("Deletec");


        GroupLayout clientButtonsLayout = new GroupLayout(clientButtons);
        clientButtons.setLayout(clientButtonsLayout);


        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();


                buttonmenuPenal.removeAll();
                buttonmenuPenal.revalidate();
                buttonmenuPenal.repaint();


                buttonmenuPenal.add(clientButtons);
                buttonmenuPenal.invalidate();
                buttonmenuPenal.validate();

            }
        });
        clientButtonsLayout.setHorizontalGroup(clientButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(clientButtonsLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(clientButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addButtonC, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showButtonC, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(deleteButtonC, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        clientButtonsLayout.setVerticalGroup(clientButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(clientButtonsLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(addButtonC).addGap(45, 45, 45).addComponent(showButtonC).addGap(45, 45, 45).addComponent(deleteButtonC).addContainerGap(136, Short.MAX_VALUE)));


        //---------------------------------------------------------------
        //----SALA---------------------------------------------------------
        addSala = new JButton();
        showSala = new JButton();
        deleteSala = new JButton();
        lovSala = new JButton();
        detailByNume = new JButton();

        salaButtons = new JPanel();
        salaWork = new JPanel();
        findSala = new JButton();

        addSala.setText("AddS");
        showSala.setText("ShowS");
        deleteSala.setText("DeleteS");
        findSala.setText("FindTP");
        lovSala.setText("Sala:Bilete");
        detailByNume.setText("Details by name");

        GroupLayout salaButtonsLayout = new GroupLayout(salaButtons);
        salaButtons.setLayout(salaButtonsLayout);


        GroupLayout salaWorkLayout = new GroupLayout(salaWork);
        salaWork.setLayout(salaWorkLayout);


        salaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                buttonmenuPenal.removeAll();
                buttonmenuPenal.revalidate();
                buttonmenuPenal.repaint();


                buttonmenuPenal.add(salaButtons);
                buttonmenuPenal.invalidate();
                buttonmenuPenal.validate();

            }
        });

        salaButtonsLayout.setHorizontalGroup(salaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(salaButtonsLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(salaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addSala, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showSala, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(findSala, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(deleteSala, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lovSala, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailByNume, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)


        ).addContainerGap()));
        salaButtonsLayout.setVerticalGroup(salaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(salaButtonsLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(addSala).addGap(45, 45, 45).addComponent(showSala).addGap(45, 45, 45).addComponent(findSala).addGap(45, 45, 45).addComponent(deleteSala)
                .addGap(45, 45, 45)
                .addComponent(lovSala)
                .addGap(45, 65, 100)
                .addComponent(detailByNume)
                .addContainerGap(136, Short.MAX_VALUE)));


        addSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                JLabel addRanduriLabel = new JLabel("Randuri: ");
                JTextField addRanduriText = new JTextField();
                addRanduriText.setColumns(20);

                JLabel addLocuriLabel = new JLabel("Locuri: ");
                JTextField addLocuriText = new JTextField();
                addLocuriText.setColumns(20);

                JLabel addTipSalaLabel = new JLabel("TipSala: ");
                JTextField addTipSalaText = new JTextField();
                addTipSalaText.setColumns(20);


                JButton addButtonS = new JButton("Add Sala");


                addButtonS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int randuri = Integer.parseInt(addRanduriText.getText());
                        int locuri = Integer.parseInt(addLocuriText.getText());
                        String tipSala = addTipSalaText.getText();


                        SalaMan salaMan = new SalaMan(connection);


                        try {
                            salaMan.addSala(randuri, locuri, tipSala);
                            errorMessage("Adaugat cu success", "Adaugare Sala");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                salaWork.add(addRanduriLabel);
                salaWork.add(addRanduriText);
                salaWork.add(addLocuriLabel);
                salaWork.add(addLocuriText);
                salaWork.add(addTipSalaLabel);
                salaWork.add(addTipSalaText);
                salaWork.add(addButtonS);


                workspacePanal.add(salaWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });
        lovSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SalaMan salaMan = new SalaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    Map<String, String> salaList = salaMan.salaBilete();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("TIPSALA          -          Bilete");
                    JLabel separator = new JLabel("|-------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);

                    for (Map.Entry<String, String> entry : salaList.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                        JLabel docLabel = new JLabel(entry.getKey() + "                    " + "" + "                     " + entry.getValue());
                        salaWork.add(docLabel);
                    }


                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        detailByNume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SalaMan salaMan = new SalaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    List<String> salaList = salaMan.getCi();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("           Nume Prenume");
                    JLabel separator = new JLabel("|-------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);
                    for (String s : salaList) {
                        JLabel docLabel = new JLabel(s);
                        salaWork.add(docLabel);

                    }

                    JLabel numeAlesLabel = new JLabel("Numele ales: ");
                    JTextField numeAlesText = new JTextField();
                    numeAlesText.setColumns(20);
                    salaWork.add(numeAlesLabel);
                    salaWork.add(numeAlesText);

                    JLabel prenumeAlesLabel = new JLabel("Prenumele ales: ");
                    JTextField prenumeAlesText = new JTextField();
                    prenumeAlesText.setColumns(20);
                    salaWork.add(prenumeAlesLabel);
                    salaWork.add(prenumeAlesText);

                    JButton numeCI = new JButton("Cautare");
                    salaWork.add(numeCI);

                    numeCI.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            SalaMan salaMan = new SalaMan(connection);

                            salaWork.removeAll();
                            salaWork.revalidate();
                            salaWork.repaint();

                            workspacePanal.removeAll();
                            workspacePanal.revalidate();
                            workspacePanal.repaint();

                            try {

                                Map<String, String> salaList = salaMan.detNume(numeAlesText.getText(), prenumeAlesText.getText());
                                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                                JLabel titleLabel = new JLabel("MALL                      FILM");
                                JLabel separator = new JLabel("|-------------------------------------|");

                                salaWork.add(titleLabel);
                                salaWork.add(separator);

                                for (Map.Entry<String, String> entry : salaList.entrySet()) {
                                    System.out.println(entry.getKey() + ":" + entry.getValue());
                                    JLabel docLabel = new JLabel(entry.getKey().substring(0, entry.getKey().length() - 1) + "                    " + "" + "                     " + entry.getValue());
                                    salaWork.add(docLabel);
                                }


                                workspacePanal.add(salaWork);
                                workspacePanal.invalidate();
                                workspacePanal.validate();


                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }


                        }
                    });


                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        showSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SalaMan salaMan = new SalaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Sala> salaList = salaMan.showAll();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Randuri          Locuri          TipSala");
                    JLabel separator = new JLabel("|----------------------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);


                    for (Sala sala : salaList) {
                        JLabel docLabel = new JLabel(sala.getRanduri() + "                    " + sala.getLocuri() + "                     " + sala.getTipSala());
                        salaWork.add(docLabel);
                    }

                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        findSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                JLabel findLabel = new JLabel("Introduceti un tip de sala: ");
                JTextField findText = new JTextField();
                findText.setColumns(20);

                JButton findButton = new JButton("Find");

                findButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tipSala = findText.getText();
                        SalaMan salaMan = new SalaMan(connection);
                        try {
                            List<Sala> salaList = salaMan.findSalaByTipSala(tipSala);

                            String listOfDoctors = "Randuri          Locuri          TipSala\n";
                            listOfDoctors += "|----------------------------------------------------------|\n";

                            for (Sala sala : salaList) {
                                listOfDoctors += sala.getRanduri() + "                    " + sala.getLocuri() + "                     " + sala.getTipSala();
                            }

                            errorMessage(listOfDoctors, "Lista de doctori");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });

                salaWork.add(findLabel);
                salaWork.add(findText);
                salaWork.add(findButton);

                workspacePanal.add(salaWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });


        deleteSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                JLabel addRanduriLabel = new JLabel("Randuri: ");
                JTextField addRanduriText = new JTextField();
                addRanduriText.setColumns(20);

                JLabel addLocuriLabel = new JLabel("Locuri: ");
                JTextField addLocuriText = new JTextField();
                addLocuriText.setColumns(20);

                JLabel addTipSalaLabel = new JLabel("TipSala: ");
                JTextField addTipSalaText = new JTextField();
                addTipSalaText.setColumns(20);


                JButton deleteButtonS = new JButton("Delete Sala");

                deleteButtonS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int randuri = Integer.parseInt(addRanduriText.getText());
                        int locuri = Integer.parseInt(addLocuriText.getText());
                        String tipSala = addTipSalaText.getText();

                        SalaMan salaMan = new SalaMan(connection);


                        try {
                            salaMan.deleteSala(randuri, locuri, tipSala);
                            errorMessage("Sters cu success", "Stergere sala");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                salaWork.add(addRanduriLabel);
                salaWork.add(addRanduriText);
                salaWork.add(addLocuriLabel);
                salaWork.add(addLocuriText);
                salaWork.add(addTipSalaLabel);
                salaWork.add(addTipSalaText);
                salaWork.add(deleteButtonS);


                workspacePanal.add(salaWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });
        //-----------------------------------------------------------
        //---CINEMA--------------------------------------------------
        addCinema = new JButton();
        showCinema = new JButton();
        deleteCinema = new JButton();
        incaCinema = new JButton();
        cliCinema = new JButton();
        ciByCinema = new JButton();
        cinemaButtons = new JPanel();
        cinemaWork = new JPanel();
        fiByCinema = new JButton();

        addCinema.setText("AddCi");
        showCinema.setText("ShowCi");
        deleteCinema.setText("DeleteCi");
        incaCinema.setText("Incasari");
        cliCinema.setText("Incasari client");
        fiByCinema.setText("Filme by cinema");
        ciByCinema.setText("Clienti by cinema");

        GroupLayout cinemaButtonsLayout = new GroupLayout(cinemaButtons);
        cinemaButtons.setLayout(cinemaButtonsLayout);


        GroupLayout cinemaWorkLayout = new GroupLayout(cinemaWork);
        cinemaWork.setLayout(cinemaWorkLayout);

        cinemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                buttonmenuPenal.removeAll();
                buttonmenuPenal.revalidate();
                buttonmenuPenal.repaint();


                buttonmenuPenal.add(cinemaButtons);
                buttonmenuPenal.invalidate();
                buttonmenuPenal.validate();

            }
        });

        cinemaButtonsLayout.setHorizontalGroup(cinemaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(cinemaButtonsLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(cinemaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(deleteCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(incaCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(cliCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(fiByCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ciByCinema, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)


        ).addContainerGap()));
        cinemaButtonsLayout.setVerticalGroup(cinemaButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(cinemaButtonsLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(addCinema).addGap(45, 45, 45).addComponent(showCinema).addGap(45, 45, 45).addComponent(deleteCinema).addGap(45, 45, 45).addComponent(incaCinema).addGap(45, 45, 45).addComponent(cliCinema).addGap(45, 45, 45).addComponent(fiByCinema).addGap(45, 45, 45).addComponent(ciByCinema).addContainerGap(136, Short.MAX_VALUE)));

        addCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cinemaWork.removeAll();
                cinemaWork.revalidate();
                cinemaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                cinemaWork.setLayout(new BoxLayout(cinemaWork, BoxLayout.Y_AXIS));

                JLabel addLocatieLabel = new JLabel("Locatie: ");
                JTextField addLocatieText = new JTextField();
                addLocatieText.setColumns(20);

                JLabel addAdresaLabel = new JLabel("Adresa: ");
                JTextField addAdresaText = new JTextField();
                addAdresaText.setColumns(20);

                JLabel addTelefonLabel = new JLabel("Telefon: ");
                JTextField addTelefonText = new JTextField();
                addTelefonText.setColumns(20);

                JLabel addOrasLabel = new JLabel("Oras: ");
                JTextField addOrasText = new JTextField();
                addOrasText.setColumns(20);

                JLabel addJudetLabel = new JLabel("Judet: ");
                JTextField addJudetText = new JTextField();
                addJudetText.setColumns(20);


                JButton addButtonCI = new JButton("Add Cinema");


                addButtonCI.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String locatie = addLocatieText.getText();
                        String adresa = addAdresaText.getText();
                        String telefon = addTelefonText.getText();
                        String oras = addOrasText.getText();
                        String judet = addJudetText.getText();


                        CinemaMan cinemaMan = new CinemaMan(connection);


                        try {
                            cinemaMan.addCinema(locatie, adresa, telefon, oras, judet);
                            errorMessage("Adaugat cu success", "Adaugare Sala");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                cinemaWork.add(addLocatieLabel);
                cinemaWork.add(addLocatieText);
                cinemaWork.add(addAdresaLabel);
                cinemaWork.add(addAdresaText);
                cinemaWork.add(addTelefonLabel);
                cinemaWork.add(addTelefonText);
                cinemaWork.add(addOrasLabel);
                cinemaWork.add(addOrasText);
                cinemaWork.add(addJudetLabel);
                cinemaWork.add(addJudetText);
                cinemaWork.add(addButtonCI);


                workspacePanal.add(cinemaWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });

        deleteCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cinemaWork.removeAll();
                cinemaWork.revalidate();
                cinemaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                cinemaWork.setLayout(new BoxLayout(cinemaWork, BoxLayout.Y_AXIS));

                JLabel addLocatieLabel = new JLabel("Locatie: ");
                JTextField addLocatieText = new JTextField();
                addLocatieText.setColumns(20);

                JLabel addAdresaLabel = new JLabel("Adresa: ");
                JTextField addAdresaText = new JTextField();
                addAdresaText.setColumns(20);

                JLabel addTelefonLabel = new JLabel("Telefon: ");
                JTextField addTelefonText = new JTextField();
                addTelefonText.setColumns(20);

                JLabel addOrasLabel = new JLabel("Oras: ");
                JTextField addOrasText = new JTextField();
                addOrasText.setColumns(20);

                JLabel addJudetLabel = new JLabel("Judet: ");
                JTextField addJudetText = new JTextField();
                addJudetText.setColumns(20);


                JButton addButtonCI = new JButton("Delete Cinema");


                addButtonCI.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String locatie = addLocatieText.getText();
                        String adresa = addAdresaText.getText();
                        String telefon = addTelefonText.getText();
                        String oras = addOrasText.getText();
                        String judet = addJudetText.getText();


                        CinemaMan cinemaMan = new CinemaMan(connection);


                        try {
                            cinemaMan.deleteCinema(locatie, adresa, telefon, oras, judet);
                            errorMessage("Sters cu success", "Stergere Cinema");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                cinemaWork.add(addLocatieLabel);
                cinemaWork.add(addLocatieText);
                cinemaWork.add(addAdresaLabel);
                cinemaWork.add(addAdresaText);
                cinemaWork.add(addTelefonLabel);
                cinemaWork.add(addTelefonText);
                cinemaWork.add(addOrasLabel);
                cinemaWork.add(addOrasText);
                cinemaWork.add(addJudetLabel);
                cinemaWork.add(addJudetText);
                cinemaWork.add(addButtonCI);


                workspacePanal.add(cinemaWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });
        incaCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CinemaMan cinemaMan = new CinemaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    Map<String, String> cinemaMap = cinemaMan.incasariCinema();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Locatie                              Incasari");
                    JLabel separator = new JLabel("|----------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);

                    for (Map.Entry<String, String> entry : cinemaMap.entrySet()) {
                        JLabel docLabel = new JLabel(entry.getKey() + "                                       " + entry.getValue());
                        salaWork.add(docLabel);
                    }

                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        cliCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CinemaMan cinemaMan = new CinemaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    Map<String, String> cinemaMap = cinemaMan.cliCinema();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Incasari                              Client");
                    JLabel separator = new JLabel("|----------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);

                    for (Map.Entry<String, String> entry : cinemaMap.entrySet()) {
                        JLabel docLabel = new JLabel(entry.getValue() + "                                       " + entry.getKey());
                        salaWork.add(docLabel);
                    }

                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        ciByCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CinemaMan cinemaMan = new CinemaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Cinema> cinemaList = cinemaMan.showAll();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Locatie          Adresa            Telefon                    Oras                   Judet  ");
                    JLabel separator = new JLabel("|--------------------------------------------------------------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);


                    for (Cinema cinema : cinemaList) {
                        JLabel docLabel = new JLabel(cinema.getLocatie() + "               " + cinema.getAdresa() + "                " + cinema.getTelefon() + "              " + cinema.getOras() + "             " + cinema.getJudet());
                        salaWork.add(docLabel);
                    }
                    JLabel cCinemaLabel = new JLabel("Cinema ales :  ");
                    JTextField cCinemaText = new JTextField();
                    cCinemaText.setColumns(20);
                    salaWork.add(cCinemaLabel);
                    salaWork.add(cCinemaText);

                    JButton cCinemaFindCI = new JButton("Cautare Filme");
                    salaWork.add(cCinemaFindCI);

                    cCinemaFindCI.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            CinemaMan cinemaMan = new CinemaMan(connection);

                            salaWork.removeAll();
                            salaWork.revalidate();
                            salaWork.repaint();

                            workspacePanal.removeAll();
                            workspacePanal.revalidate();
                            workspacePanal.repaint();

                            try {
                                List<String> cinemaList = cinemaMan.clibyCin(cCinemaText.getText());
                                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                                JLabel titleLabel = new JLabel("   Nume Prenume ");
                                JLabel separator = new JLabel("|---------------------|");

                                salaWork.add(titleLabel);
                                salaWork.add(separator);


                                for (String s : cinemaList) {
                                    JLabel docLabel = new JLabel(s);
                                    salaWork.add(docLabel);
                                }


                                workspacePanal.add(salaWork);
                                workspacePanal.invalidate();
                                workspacePanal.validate();


                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }


                        }
                    });


                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        fiByCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CinemaMan cinemaMan = new CinemaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Cinema> cinemaList = cinemaMan.showAll();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Locatie          Adresa            Telefon                    Oras                   Judet  ");
                    JLabel separator = new JLabel("|--------------------------------------------------------------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);


                    for (Cinema cinema : cinemaList) {
                        JLabel docLabel = new JLabel(cinema.getLocatie() + "               " + cinema.getAdresa() + "                " + cinema.getTelefon() + "              " + cinema.getOras() + "             " + cinema.getJudet());
                        salaWork.add(docLabel);
                    }
                    JLabel cCinemaLabel = new JLabel("Cinema ales :  ");
                    JTextField cCinemaText = new JTextField();
                    cCinemaText.setColumns(20);
                    salaWork.add(cCinemaLabel);
                    salaWork.add(cCinemaText);

                    JButton cCinemaFindCI = new JButton("Cautare Filme");
                    salaWork.add(cCinemaFindCI);

                    cCinemaFindCI.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            CinemaMan cinemaMan = new CinemaMan(connection);

                            salaWork.removeAll();
                            salaWork.revalidate();
                            salaWork.repaint();

                            workspacePanal.removeAll();
                            workspacePanal.revalidate();
                            workspacePanal.repaint();

                            try {
                                List<String> cinemaList = cinemaMan.fibyCin(cCinemaText.getText());
                                salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                                JLabel titleLabel = new JLabel("   Film ");
                                JLabel separator = new JLabel("|-----------|");

                                salaWork.add(titleLabel);
                                salaWork.add(separator);


                                for (String s : cinemaList) {
                                    JLabel docLabel = new JLabel(s);
                                    salaWork.add(docLabel);
                                }


                                workspacePanal.add(salaWork);
                                workspacePanal.invalidate();
                                workspacePanal.validate();


                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }


                        }
                    });


                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        showCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CinemaMan cinemaMan = new CinemaMan(connection);

                salaWork.removeAll();
                salaWork.revalidate();
                salaWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Cinema> cinemaList = cinemaMan.showAll();
                    salaWork.setLayout(new BoxLayout(salaWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Locatie          Adresa            Telefon                    Oras                   Judet  ");
                    JLabel separator = new JLabel("|--------------------------------------------------------------------------------------------------|");

                    salaWork.add(titleLabel);
                    salaWork.add(separator);


                    for (Cinema cinema : cinemaList) {
                        JLabel docLabel = new JLabel(cinema.getLocatie() + "               " + cinema.getAdresa() + "                " + cinema.getTelefon() + "              " + cinema.getOras() + "             " + cinema.getJudet());
                        salaWork.add(docLabel);
                    }

                    workspacePanal.add(salaWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        //------------FILM----------------
        addFilm = new JButton();
        showFilm = new JButton();
        deleteFilm = new JButton();
        updateButton = new JButton();
        choFi = new JButton();
        filmBi = new JButton();
        filmButtons = new JPanel();
        filmWork = new JPanel();
        numbLimba = new JButton();

        addFilm.setText("AddF");
        showFilm.setText("ShowF");
        deleteFilm.setText("DeleteF");
        updateButton.setText("UpdateF");
        filmBi.setText("Popularitate");
        choFi.setText("Difuzare");
        numbLimba.setText("Film by lang");

        GroupLayout filmButtonsLayout = new GroupLayout(filmButtons);
        filmButtons.setLayout(filmButtonsLayout);


        GroupLayout filmWorkLayout = new GroupLayout(filmWork);
        filmWork.setLayout(filmWorkLayout);

        filmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                buttonmenuPenal.removeAll();
                buttonmenuPenal.revalidate();
                buttonmenuPenal.repaint();


                buttonmenuPenal.add(filmButtons);
                buttonmenuPenal.invalidate();
                buttonmenuPenal.validate();

            }
        });

        filmButtonsLayout.setHorizontalGroup(filmButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(filmButtonsLayout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE).addGroup(filmButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addFilm, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showFilm, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(deleteFilm, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(updateButton, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(filmBi, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(choFi, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(numbLimba, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        filmButtonsLayout.setVerticalGroup(filmButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(filmButtonsLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(addFilm).addGap(45, 45, 45).addComponent(showFilm).addGap(45, 45, 45).addComponent(deleteFilm).addGap(45, 45, 45).addComponent(updateButton).addGap(45, 45, 45).addComponent(filmBi).addGap(45, 45, 45).addComponent(choFi).addGap(45, 45, 45).addComponent(numbLimba).addContainerGap(136, Short.MAX_VALUE)));

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                JLabel updateNumeLabel = new JLabel("Denumirea filmului care trebuie actualizat: ");
                JTextField updateNumeText = new JTextField();
                updateNumeText.setColumns(20);


                JLabel updateInfoLabel = new JLabel("Mai jos se introduc noile informatii despre film");


                JLabel updateDurataFilmLabel = new JLabel("Durata film (min): ");
                JTextField updateDurataFilmText = new JTextField();
                updateDurataFilmText.setColumns(20);

                JLabel updateLimbaLabel = new JLabel("Limba Difuzare (RO/EN): ");
                JTextField updateLimbaText = new JTextField();
                updateLimbaText.setColumns(20);


                JLabel updateDataLabel = new JLabel("Data Aparitie: ");
                JTextField updateDataText = new JTextField();
                updateDataText.setColumns(20);

                JLabel updateDescrLabel = new JLabel("Descriere: ");
                JTextField updateDescrText = new JTextField();
                updateDescrText.setColumns(20);


                JButton updateButtonCI = new JButton("Update Film");


                updateButtonCI.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String denumireFilm = updateNumeText.getText();
                        String durataFilm = updateDurataFilmText.getText();
                        String limbaDifuzare = updateLimbaText.getText();
                        Date dataAparitie = Date.valueOf(updateDataText.getText());
                        String descriere = updateDescrText.getText();


                        FilmMan cinemaMan = new FilmMan(connection);


                        try {
                            int ok = cinemaMan.updateFilm(denumireFilm, durataFilm, limbaDifuzare, dataAparitie, descriere);
                            if (ok == 1) {
                                errorMessage("Actualizat cu success", "Actualizare Film");
                            } else {
                                errorMessage("Filmul nu exista in baza de date", "Actualizare esuata");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });

                filmWork.add(updateNumeLabel);
                filmWork.add(updateNumeText);
                filmWork.add(updateInfoLabel);
                filmWork.add(updateDurataFilmLabel);
                filmWork.add(updateDurataFilmText);
                filmWork.add(updateLimbaLabel);
                filmWork.add(updateLimbaText);
                filmWork.add(updateDataLabel);
                filmWork.add(updateDataText);
                filmWork.add(updateDescrLabel);
                filmWork.add(updateDescrText);
                filmWork.add(updateButtonCI);

                workspacePanal.add(filmWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });


        addFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                JLabel addLocatieLabel = new JLabel("Denumire Film: ");
                JTextField addLocatieText = new JTextField();
                addLocatieText.setColumns(20);

                JLabel addAdresaLabel = new JLabel("Durata film (min): ");
                JTextField addAdresaText = new JTextField();
                addAdresaText.setColumns(20);

                JLabel addTelefonLabel = new JLabel("Limba Difuzare (RO/EN): ");
                JTextField addTelefonText = new JTextField();
                addTelefonText.setColumns(20);

                JLabel addOrasLabel = new JLabel("Data Aparitie: ");
                JTextField addOrasText = new JTextField();
                addOrasText.setColumns(20);

                JLabel addJudetLabel = new JLabel("Descriere: ");
                JTextField addJudetText = new JTextField();
                addJudetText.setColumns(20);


                JButton addButtonCI = new JButton("Add Film");


                addButtonCI.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String denumireFilm = addLocatieText.getText();
                        String durataFilm = addAdresaText.getText();
                        String limbaDifuzare = addTelefonText.getText();
                        Date dataAparitie = Date.valueOf(addOrasText.getText());
                        String descriere = addJudetText.getText();


                        FilmMan cinemaMan = new FilmMan(connection);


                        try {
                            cinemaMan.addFilm(denumireFilm, durataFilm, limbaDifuzare, dataAparitie, descriere);
                            errorMessage("Adaugat cu success", "Adaugare Film");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                filmWork.add(addLocatieLabel);
                filmWork.add(addLocatieText);
                filmWork.add(addAdresaLabel);
                filmWork.add(addAdresaText);
                filmWork.add(addTelefonLabel);
                filmWork.add(addTelefonText);
                filmWork.add(addOrasLabel);
                filmWork.add(addOrasText);
                filmWork.add(addJudetLabel);
                filmWork.add(addJudetText);
                filmWork.add(addButtonCI);


                workspacePanal.add(filmWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });


        deleteFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                JLabel addLocatieLabel = new JLabel("Denumire Film: ");
                JTextField addLocatieText = new JTextField();
                addLocatieText.setColumns(20);

                JLabel addAdresaLabel = new JLabel("Durata film (min): ");
                JTextField addAdresaText = new JTextField();
                addAdresaText.setColumns(20);

                JLabel addTelefonLabel = new JLabel("Limba Difuzare (RO/EN): ");
                JTextField addTelefonText = new JTextField();
                addTelefonText.setColumns(20);

                JLabel addOrasLabel = new JLabel("Data Aparitie: ");
                JTextField addOrasText = new JTextField();
                addOrasText.setColumns(20);

                JLabel addJudetLabel = new JLabel("Descriere: ");
                JTextField addJudetText = new JTextField();
                addJudetText.setColumns(20);


                JButton addButtonCI = new JButton("Delete Film");


                addButtonCI.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String denumireFilm = addLocatieText.getText();
                        String durataFilm = addAdresaText.getText();
                        String limbaDifuzare = addTelefonText.getText();
                        Date dataAparitie = Date.valueOf(addOrasText.getText());
                        String descriere = addJudetText.getText();


                        FilmMan cinemaMan = new FilmMan(connection);


                        try {
                            cinemaMan.deleteFilm(denumireFilm, durataFilm, limbaDifuzare, dataAparitie, descriere);
                            errorMessage("Sters cu success", "Stergere Film");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                });


                filmWork.add(addLocatieLabel);
                filmWork.add(addLocatieText);
                filmWork.add(addAdresaLabel);
                filmWork.add(addAdresaText);
                filmWork.add(addTelefonLabel);
                filmWork.add(addTelefonText);
                filmWork.add(addOrasLabel);
                filmWork.add(addOrasText);
                filmWork.add(addJudetLabel);
                filmWork.add(addJudetText);
                filmWork.add(addButtonCI);


                workspacePanal.add(filmWork);
                workspacePanal.invalidate();
                workspacePanal.validate();


            }
        });


        showFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                FilmMan filmMan = new FilmMan(connection);

                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Film> filmList = filmMan.showAll();
                    filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("DenumireFilm          DurataFilm            LimbaDifuzare                    DataAparitie                   Descriere  ");
                    JLabel separator = new JLabel("|-------------------------------------------------------------------------------------------------------------------------------------------|");

                    filmWork.add(titleLabel);
                    filmWork.add(separator);


                    for (Film film : filmList) {
                        JLabel docLabel = new JLabel(film.getDenumireFilm() + "                  " + film.getDurataFilm() + "                        " + film.getLimbaDifuzare() + "                                     " + film.getDataAparitie() + "                    " + film.getDescriere());
                        filmWork.add(docLabel);
                    }

                    workspacePanal.add(filmWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        filmBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                FilmMan filmMan = new FilmMan(connection);

                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    Map<String, String> filmMap = filmMan.filmBi();
                    filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("Numar Bilete                     DenumireFilm");
                    JLabel separator = new JLabel("|------------------------------------------------|");

                    filmWork.add(titleLabel);
                    filmWork.add(separator);

                    for (Map.Entry<String, String> entry : filmMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                        JLabel docLabel = new JLabel(entry.getValue() + "                                       " + entry.getKey());
                        filmWork.add(docLabel);
                    }


                    workspacePanal.add(filmWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        numbLimba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                FilmMan filmMan = new FilmMan(connection);

                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {

                    String filmMap = filmMan.numbLimb();
                    filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("     Film");
                    JLabel separator = new JLabel("|------------------------------------------------|");

                    filmWork.add(titleLabel);
                    filmWork.add(separator);


                    JLabel docLabel = new JLabel(filmMap);
                    filmWork.add(docLabel);


                    workspacePanal.add(filmWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        choFi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FilmMan filmMan = new FilmMan(connection);
                CinemaMan cinemaMan = new CinemaMan(connection);


                filmWork.removeAll();
                filmWork.revalidate();
                filmWork.repaint();

                workspacePanal.removeAll();
                workspacePanal.revalidate();
                workspacePanal.repaint();

                try {
                    List<Film> filmList = filmMan.showAll();
                    filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                    JLabel titleLabel = new JLabel("DenumireFilm          DurataFilm            LimbaDifuzare                    DataAparitie                   Descriere  ");
                    JLabel separator = new JLabel("|-------------------------------------------------------------------------------------------------------------------------------------------|");

                    filmWork.add(titleLabel);
                    filmWork.add(separator);


                    for (Film film : filmList) {
                        JLabel docLabel = new JLabel(film.getDenumireFilm() + "                  " + film.getDurataFilm() + "                        " + film.getLimbaDifuzare() + "                                     " + film.getDataAparitie() + "                    " + film.getDescriere());
                        filmWork.add(docLabel);
                    }

                    JLabel separator1 = new JLabel("|----------------------------------------------------------------------------------------------------------------------------------------------------------|");
                    filmWork.add(separator1);
                    List<Cinema> cinemaList = cinemaMan.showAll();
                    JLabel titleLabel2 = new JLabel("Locatie          Adresa            Telefon                    Oras                   Judet  ");
                    JLabel separator2 = new JLabel("|--------------------------------------------------------------------------------------------------|");
                    filmWork.add(titleLabel2);
                    filmWork.add(separator2);
                    for (Cinema cinema : cinemaList) {
                        JLabel docLabel = new JLabel(cinema.getLocatie() + "               " + cinema.getAdresa() + "                " + cinema.getTelefon() + "              " + cinema.getOras() + "             " + cinema.getJudet());
                        filmWork.add(docLabel);
                    }
                    JLabel locatieLabel = new JLabel("Locatie: ");
                    JTextField locatieText = new JTextField();
                    locatieText.setColumns(20);
                    filmWork.add(locatieLabel);
                    filmWork.add(locatieText);

                    JLabel filmLabel = new JLabel("Film:");
                    JTextField filmCiText = new JTextField();
                    filmCiText.setColumns(20);
                    filmWork.add(filmLabel);
                    filmWork.add(filmCiText);

                    JButton interogCI = new JButton("Search");
                    filmWork.add(interogCI);

                    interogCI.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            FilmMan filmMan = new FilmMan(connection);

                            filmWork.removeAll();
                            filmWork.revalidate();
                            filmWork.repaint();

                            workspacePanal.removeAll();
                            workspacePanal.revalidate();
                            workspacePanal.repaint();

                            try {

                                Map<String, String> filmMap = filmMan.choFi(filmCiText.getText(), locatieText.getText());
                                filmWork.setLayout(new BoxLayout(filmWork, BoxLayout.Y_AXIS));

                                JLabel titleLabel = new JLabel("ORA                     TIP SALA");
                                JLabel separator = new JLabel("|------------------------------------------------|");

                                filmWork.add(titleLabel);
                                filmWork.add(separator);

                                for (Map.Entry<String, String> entry : filmMap.entrySet()) {
                                    System.out.println(entry.getKey() + ":" + entry.getValue());
                                    JLabel docLabel = new JLabel(entry.getValue() + "                                       " + entry.getKey().substring(0, 2));
                                    filmWork.add(docLabel);
                                }


                                workspacePanal.add(filmWork);
                                workspacePanal.invalidate();
                                workspacePanal.validate();


                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }


                        }
                    });

                    workspacePanal.add(filmWork);
                    workspacePanal.invalidate();
                    workspacePanal.validate();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        //----------------------------------------------------------


        f.add(loginPanel);

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public JFrame getFrame() {
        return f;
    }

}
