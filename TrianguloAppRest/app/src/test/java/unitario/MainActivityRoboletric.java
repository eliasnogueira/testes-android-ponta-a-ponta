package unitario;

import android.widget.TextView;

import com.eliasnogueira.trianguloapp.BuildConfig;
import com.eliasnogueira.trianguloapp.R;
import com.eliasnogueira.trianguloapp.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityRoboletric {

    private MainActivity mainActivity;
    private TextView labelLado1, labelLado2, labelLado3;
    private String esperado, obtido;

    @Before
    public void preCondicao() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);

        labelLado1 = (TextView) mainActivity.findViewById(R.id.labelLado1);
        labelLado2= (TextView) mainActivity.findViewById(R.id.labelLado2);
        labelLado3 = (TextView) mainActivity.findViewById(R.id.labelLado3);
    }

    @Test
    public void testCalculaTrianguloEquilatero() {
        esperado = mainActivity.getString(R.string.label_lado1);
        obtido = labelLado1.getText().toString();

        assertEquals(esperado, obtido);
    }
}
