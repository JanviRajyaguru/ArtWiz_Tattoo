import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artwiz_tattoo.R;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] tattoName;
    String[] tprice;
    int[] image;
    LayoutInflater inflater;

    public GridAdapter(Context context, String[] tattoName, int[] image, String[] price) {
        this.context = context;
        this.tattoName = tattoName;
        this.image = image;
        this.tprice = price;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tattoName.length;
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);
        TextView textView2 = convertView.findViewById(R.id.item_price);
        imageView.setImageResource(image[position]);
        textView.setText(tattoName[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), tattoName[position], Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, Specific_Item.class);
                i.putExtra("timage", image[position]); // Pass image resource ID
                i.putExtra("tattoname", tattoName[position]); // Pass flower name
                i.putExtra("tprice", tprice[position]); // Pass price
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
