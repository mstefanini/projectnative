package ingrid.jack.matteo.projectnative;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ingrid on 13/04/2016.
 */
public class Details extends Activity {

    private TextView mTitolo;
    private ImageView mFoto;
    private TextView mData;
    private TextView mDescrizione;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        mTitolo = (TextView) findViewById(R.id.titolo);
        mData = (TextView) findViewById(R.id.dataOrario);
        mFoto = (ImageView) findViewById(R.id.immagine);
        mDescrizione = (TextView) findViewById(R.id.postContent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
