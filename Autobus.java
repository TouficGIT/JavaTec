//source sans la documentation produite par javadoc.

class Autobus {

  private Jauge placesAssises;
  private Jauge placesDebout;
  private int assis;
  private int debout;
  private int arret;
  private final PassagerStandard[] passagers;

  public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
      arret = 0;
      assis = 0;
      debout = 0;
      passagers = new PassagerStandard[NB_MAX];
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
      assis++;


  }

  public void monteeDemanderDebout(PassagerStandard p) {
      assis++;

  }

  public void allerArretSuivant() {
      arret++;
      passagers;

  }

  public void arretDemanderAssis(PassagerStandard p) {
      assis--;
      debout++;
      p.estDebout() = true;
      p.estAssis() = false;
  }

  public void arretDemanderDebout(PassagerStandard p) {
      assis++;
      debout--;
      p.estDebout() = false;
      p.estAssis() = true;
  }

  public void arretDemanderSortie(PassagerStandard p) {
      if (p.estDebout(p)) {
          debout--;
      }

      if (p.estAssis(p)) {
          assis-;
      }
      p.estDebout(p) = false;
      p.estAssis(p) = false;
  }
}
