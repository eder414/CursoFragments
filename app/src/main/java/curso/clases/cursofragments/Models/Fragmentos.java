package curso.clases.cursofragments.Models;

import curso.clases.cursofragments.Fragments.CienciaFragment;
import curso.clases.cursofragments.Fragments.DeportesFragment;
import curso.clases.cursofragments.Fragments.NoticiasFragment;
import curso.clases.cursofragments.Fragments.StaticFragment;

public class Fragmentos {

    public Fragmentos(CienciaFragment cienciaFragment, DeportesFragment deportesFragment, NoticiasFragment noticiasFragment, StaticFragment staticFragment) {
        this.cienciaFragment = cienciaFragment;
        this.deportesFragment = deportesFragment;
        this.noticiasFragment = noticiasFragment;
        this.staticFragment = staticFragment;
    }

    CienciaFragment cienciaFragment;
    DeportesFragment deportesFragment;
    NoticiasFragment noticiasFragment;
    StaticFragment staticFragment;



    public CienciaFragment getCienciaFragment() {
        return cienciaFragment;
    }

    public void setCienciaFragment(CienciaFragment cienciaFragment) {
        this.cienciaFragment = cienciaFragment;
    }

    public DeportesFragment getDeportesFragment() {
        return deportesFragment;
    }

    public void setDeportesFragment(DeportesFragment deportesFragment) {
        this.deportesFragment = deportesFragment;
    }

    public NoticiasFragment getNoticiasFragment() {
        return noticiasFragment;
    }

    public void setNoticiasFragment(NoticiasFragment noticiasFragment) {
        this.noticiasFragment = noticiasFragment;
    }

    public StaticFragment getStaticFragment() {
        return staticFragment;
    }

    public void setStaticFragment(StaticFragment staticFragment) {
        this.staticFragment = staticFragment;
    }


}
