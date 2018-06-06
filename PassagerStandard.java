//source sans la documentation produite par javadoc.

class PassagerStandard {
  private final String nomPassager;
  private final int destinationPassager;
  private Position positionPassager;

  public PassagerStandard(String nom, int destination){
    this.nomPassager=nom;
    this.destinationPassager=destination;
    positionPassager = new Position();
  }

  public String nom() {
    return this.nomPassager;
  }

  public boolean estDehors() { 
    return positionPassager.estDehors() ;
  }

  public boolean estAssis() {
    return positionPassager.estAssis();
  }

  public boolean estDebout() {
    return positionPassager.estDebout();
  }

  public void changerEnDehors() {
    positionPassager = positionPassager.dehors();
  }

  public void changerEnAssis() {
    positionPassager = positionPassager.assis();
  }

  public void changerEnDebout() {
    positionPassager = positionPassager.debout();
  }

  public void monterDans(Autobus t) {
    if (t.aPlaceAssise()){
      t.monteeDemanderAssis(this);
    }
    else if (t.aPlaceDebout()){
      t.monteeDemanderDebout(this);
    }
  }

  public void nouvelArret(Autobus bus, int numeroArret) {
    if (destinationPassager <= numeroArret){
      bus.arretDemanderSortie(this);
    }
    //else if (estDebout() && bus.aPlaceAssise()){
    //  bus.arretDemanderAssis(this);
    //}
  }
}
