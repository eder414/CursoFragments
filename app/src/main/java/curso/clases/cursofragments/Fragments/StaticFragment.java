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

public class StaticFragment extends Fragment {
    EditText editTextEstatico;
    Button btnCambiar;
    private FragmentStaticListener listener;

    public StaticFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_static, container, false);
        editTextEstatico = view.findViewById(R.id.editTextEstatico);
        btnCambiar = view.findViewById(R.id.btnCambiar);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence charSequence = editTextEstatico.getText();
                listener.onInputStaticSent(charSequence);
            }
        });

        return view;
    }
    public void ActualizarTexto(CharSequence nuevoTexto){
        editTextEstatico.setText(nuevoTexto);
    }
    public interface FragmentStaticListener{
        void onInputStaticSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context  instanceof FragmentStaticListener){
            listener = (FragmentStaticListener) context;
        }
        else{
            throw  new RuntimeException(context.toString() + "must implement FragmentStaticListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}