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

public class CienciaFragment extends Fragment {

    private EditText editTextCiencia;
    private FragmentCienciaListener listener;
    Button btnChange;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ciencia, container, false);
        editTextCiencia = view.findViewById(R.id.editTextCiencia);
        btnChange = view.findViewById(R.id.btnCambiar);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editTextCiencia.getText();
                listener.onInputCienciaSent(input);
            }
        });

        return view;
    }
    public interface FragmentCienciaListener{
        void onInputCienciaSent(CharSequence input);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCienciaListener){
            listener = (FragmentCienciaListener) context;
        }else{
            throw  new RuntimeException(context.toString() + "must implement FragmentAListener");
        }
    }
    public void ActualizarEditText(CharSequence newText){
        editTextCiencia.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}