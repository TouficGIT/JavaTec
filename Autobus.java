//source sans la documentation produite par javadoc.

class Autobus {

  private Jauge placesAssises;
  private Jauge placesDebout;
  private int assis;
  private int debout;
  private int arret = 0;
  private int nb_passagers = 0;
  private PassagerStandard[] passager_standard;

  public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
      arret = 0;
      assis = 0;
      debout = 0;
      passager_standard = new PassagerStandard[nbPlaceAssise+nbPlaceDebout];
      placesAssises = new Jauge(nbPlaceAssise,assis);
      placesDebout = new Jauge(nbPlaceDebout,debout);
  }

  public boolean aPlaceAssise() {

    if (placesAssises.estVert()) {
        return true;
    }
    else
        return false;
  }

  public boolean aPlaceDebout() {
      if (placesDebout.estVert()) {
          return true;
      }
      else
          return false;
  }

  public void monteeDemanderAssis(PassagerStandard p) {
      // Si le passager n'est pas dehors ou qu'il n'y a pas de place assise
      if (!p.estDehors() || !aPlaceAssise()) {
        System.out.println("Demande de montée assise impossible");
        return;
      }
      placesAssises.incrementer(); // on incrémente le nombre de places assises prisent
      p.changerEnAssis();
      passager_standard[nb_passagers] = p;
      nb_passagers++;
  }

  public void monteeDemanderDebout(PassagerStandard p) {
      // Si le passager n'est pas dehors ou qu'il n'y a pas de place assise
      if (!p.estDehors() || !aPlaceDebout()) {
          System.out.println("Demande de montée debout impossible");
          return;
      }
      placesAssises.incrementer(); // on incrémente le nombre de places assises prisent
      p.changerEnAssis();
      passager_standard[nb_passagers] = p;
      nb_passagers++;

  }

  public void allerArretSuivant() {

      arret++;

      for (int i = 0; i < passager_standard.length; i++) {
          if (passager_standard[i] != null)
              passager_standard[i].nouvelArret(this, arret);
      }
  }


  public void arretDemanderAssis(PassagerStandard p) {
      // Si le passager n'est pas dehors ou qu'il n'y a pas de place assise
      if (!p.estDehors() || aPlaceAssise()) {
          System.out.println("Demande de place assise, à l'arret, impossible");
          return;
      }
      placesDebout.decrementer();
      placesAssises.incrementer(); // on incrémente le nombre de places assises prisent
      p.changerEnAssis();
  }

  public void arretDemanderDebout(PassagerStandard p) {
      // Si le passager n'est pas dehors ou qu'il n'y a pas de place assise
      if (!p.estDehors() || aPlaceDebout()) {
          System.out.println("Demande de place debout, à l'arret, impossible");
          return;
      }
      placesAssises.decrementer();
      placesDebout.incrementer(); // on incrémente le nombre de places assises prisent
      p.changerEnDebout();
  }

  public void arretDemanderSortie(PassagerStandard p) {
      if (p.estDebout()) {
          placesDebout.decrementer();
      }

      else if (p.estAssis()) {
          placesAssises.decrementer();
      }

      else {
          return;
      }

      for (int i = 0; i < passager_standard.length; i++) {
          if (passager_standard[i] == p)
              passager_standard[i] = null;
      }

      p.changerEnDehors();
      nb_passagers--;

  }
}
