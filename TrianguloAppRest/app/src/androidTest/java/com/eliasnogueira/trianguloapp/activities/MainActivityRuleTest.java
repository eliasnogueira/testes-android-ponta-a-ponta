package com.eliasnogueira.trianguloapp.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import android.widget.TextView;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.eliasnogueira.trianguloapp.R;


@RunWith(AndroidJUnit4.class)
public class MainActivityRuleTest {

    @Rule
    public final ActivityTestRule<MainActivity> myRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity;
    private TextView labelLado1, labelLado2, labelLado3;
    private String esperado, obtido;

    @Before
    public void preCondicao() throws Exception {
        mainActivity = myRule.getActivity();

        labelLado1 = (TextView) mainActivity.findViewById(R.id.labelLado1);
        labelLado2= (TextView) mainActivity.findViewById(R.id.labelLado2);
        labelLado3 = (TextView) mainActivity.findViewById(R.id.labelLado3);
    }

    @Test
    public void testPrecondicoes() {
        assertNotNull("mainActiviry é null", mainActivity);
    }

    @Test
    public void testLabelLado1() {
        esperado = mainActivity.getString(R.string.label_lado1);
        obtido = labelLado1.getText().toString();

        assertEquals(esperado, obtido);
    }



}