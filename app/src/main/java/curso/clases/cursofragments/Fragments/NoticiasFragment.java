package curso.clases.cursofragments.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import curso.clases.cursofragments.R;

public class NoticiasFragment extends Fragment {

    Button btmCambiar;
    EditText editTextNoticias;

    private FragmentNoticiasListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        btmCambiar = view.findViewById(R.id.btnCambiar);
        editTextNoticias = view.findViewById(R.id.editTextNoticias);

        btmCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence texto = editTextNoticias.getText();
                listener.onInputNoticiasSent(texto);
            }
        });

        return view;
    }
    public interface FragmentNoticiasListener{
        void onInputNoticiasSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentNoticiasListener){
            listener = (FragmentNoticiasListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "debe implementar la interface FragmentNoticiasListener");
        }
    }

    public void ActualizarTexto(CharSequence nuevoTexto){
        editTextNoticias.setText(nuevoTexto);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}