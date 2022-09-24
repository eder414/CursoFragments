package curso.clases.cursofragments.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import curso.clases.cursofragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeportesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeportesFragment extends Fragment {
    FragmentDeportesListener listener;
    EditText editTextDeportes;
    Button btnCambiar;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeportesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeportesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeportesFragment newInstance(String param1, String param2) {
        DeportesFragment fragment = new DeportesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deportes, container, false);
        btnCambiar = view.findViewById(R.id.btnCambiar);
        editTextDeportes = view.findViewById(R.id.editTextDeportes);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence charSequence = editTextDeportes.getText();
                listener.onInputDeportesSent(charSequence);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context  instanceof StaticFragment.FragmentStaticListener){
            listener = (DeportesFragment.FragmentDeportesListener) context;
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
    public interface FragmentDeportesListener{
        void onInputDeportesSent(CharSequence input);
    }
    public void ActualizarTexto(CharSequence nuevoTexto){
        System.out.println("deportes Fragment: "+nuevoTexto);
        editTextDeportes.setText(nuevoTexto);
    }
}