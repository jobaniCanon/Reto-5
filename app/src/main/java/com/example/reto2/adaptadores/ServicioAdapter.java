package com.example.reto2.adaptadores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto2.R;
import com.example.reto2.modelos.Servicio;

import java.util.ArrayList;

public class ServicioAdapter extends BaseAdapter {

    Context context;
    ArrayList<Servicio> servicios;
    LayoutInflater inflater;
    private SQLiteDatabase sqLiteDatabase;


    public ServicioAdapter(Context context, ArrayList<Servicio> servicios) {
        this.context = context;
        this.servicios = servicios;
    }

    @Override
    public int getCount() {
        return servicios.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imgItem);
        TextView campo1 = convertView.findViewById(R.id.tvCampo1);
        TextView campo2 = convertView.findViewById(R.id.tvCampo2);
        TextView campo3 = convertView.findViewById(R.id.tvCampo3);
        TextView campoId = convertView.findViewById(R.id.tvId);

        Servicio servicio = servicios.get(position);
        byte[] image = servicio.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ servicio.getId());
        campo1.setText(servicio.getName());
        campo2.setText(servicio.getDescription());
        campo3.setText(servicio.getPrice());
        imageView.setImageBitmap(bitmap);

        //---------------------------------------------------------------------------------

      /*  Button boton1 = (Button) convertView.findViewById(R.id.boton1_item);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Guardado en favoritos", Toast.LENGTH_LONG).show();
                sqLiteDatabase.execSQL("INSERT INTO favoritos VALUES (1, '"+datosItem.getTitulo()+"', '"+datosItem.getTitulo()+"')");
            }
        });*/

        return convertView;
    }
}
