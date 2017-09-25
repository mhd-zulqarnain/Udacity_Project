package criminalintent.android.zaadjava.com.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Date;

/**
 * Created by zulup on 5/12/2017.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTtitleField;
    private Button mDate;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(Bundle saveInstanceState){  //we override it to initialize non graphical content
        super.onCreate(saveInstanceState);
        mCrime= new Crime();

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){   //we override it to do any graphical initialisations
        View v=inflater.inflate(R.layout.fragment_crime,container,false);
        mDate=(Button) v.findViewById(R.id.crime_date);
        mDate.setText(mCrime.getDate().toString());
        mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setSolved(b);
            }
        });

        mTtitleField =(EditText)v.findViewById(R.id.crime_title);
        mTtitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return v;
    }

}
