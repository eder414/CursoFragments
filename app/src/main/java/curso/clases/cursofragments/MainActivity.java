package curso.clases.cursofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import curso.clases.cursofragments.Fragments.CienciaFragment;
import curso.clases.cursofragments.Fragments.DeportesFragment;
import curso.clases.cursofragments.Fragments.NoticiasFragment;
import curso.clases.cursofragments.Fragments.StaticFragment;
import curso.clases.cursofragments.Models.Fragmentos;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
            NoticiasFragment.FragmentNoticiasListener,
            StaticFragment.FragmentStaticListener,
            DeportesFragment.FragmentDeportesListener,
            CienciaFragment.FragmentCienciaListener{

    FragmentManager fragmentManager;
    /*NewsFragment newsFragment;
    DataChangeFragment dataChangeFragment;*/
    Fragmentos fragmentos;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*botones para los fragmentos*/
        Button btnNoticias, btnDeportes, btnCiencia;

        btnNoticias = findViewById(R.id.btnNoticias);
        btnDeportes = findViewById(R.id.btnDeportes);
        btnCiencia = findViewById(R.id.btnCiencia);

        /*Instancias todos los fragmentos*/
        fragmentos = new Fragmentos(new  CienciaFragment() , new DeportesFragment(),new NoticiasFragment(), new StaticFragment());
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.FragmentContainerViewDinamico, fragmentos.getDeportesFragment(),null)
                .replace(R.id.FragmentContainerViewEstatico, fragmentos.getStaticFragment(),null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit()
                ;

        btnNoticias.setOnClickListener(this);
        btnDeportes.setOnClickListener(this);
        btnCiencia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNoticias:
                    CambiarFragmento(fragmentos.getNoticiasFragment());
                break;
            case R.id.btnCiencia:
                    CambiarFragmento(fragmentos.getCienciaFragment());
                break;
            case R.id.btnDeportes:
                    CambiarFragmento(fragmentos.getDeportesFragment());
                break;
        }
    }

    private <T> void CambiarFragmento(T fragmento) {
        fragmentManager.beginTransaction()
                .replace(R.id.FragmentContainerViewDinamico, (Fragment) fragmento,null)
                .replace(R.id.FragmentContainerViewEstatico, fragmentos.getStaticFragment(),null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit()
        ;
    }

    @Override
    public void onInputNoticiasSent(CharSequence texto) {
        fragmentos.getStaticFragment().ActualizarTexto(texto);
    }

    @Override
    public void onInputStaticSent(CharSequence texto) {
        fragmentos.getNoticiasFragment().ActualizarTexto(texto);
    }

    @Override
    public void onInputDeportesSent(CharSequence input) {
        fragmentos.getStaticFragment().ActualizarTexto(input);
    }

    @Override
    public void onInputCienciaSent(CharSequence input) {
        fragmentos.getStaticFragment().ActualizarTexto(input);
    }
}