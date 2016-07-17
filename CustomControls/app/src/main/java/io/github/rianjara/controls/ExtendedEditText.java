package io.github.rianjara.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by richard.jara on 16/07/2016.
 */
public class ExtendedEditText extends EditText {

    private Paint p1, p2;
    private float escala;

    public ExtendedEditText(Context context) {
        super(context);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializacion();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Resctangulo de color negro
        canvas.drawRect(this.getWidth()-30*escala,5*escala,this.getWidth()-5*escala,20*escala,p1);

        //Pintar el # de caracteres (contador)
        canvas.drawText(""+this.getText().toString().length(),this.getWidth()-28*escala,17*escala,p2);

    }

    private void inicializacion() {
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLACK);
        p1.setStyle(Paint.Style.FILL);

        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setTextSize(20);

        escala = getResources().getDisplayMetrics().density;
    }
}
