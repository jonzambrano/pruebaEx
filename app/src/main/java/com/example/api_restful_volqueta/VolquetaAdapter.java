package com.example.api_restful_volqueta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VolquetaAdapter extends RecyclerView.Adapter<VolquetaAdapter.VolquetaViewHolder> {

    private List<Volqueta> volquetaList;
    private Context context;

    public VolquetaAdapter(Context context, List<Volqueta> volquetaList) {
        this.context = context;
        this.volquetaList = volquetaList;
    }

    @NonNull
    @Override
    public VolquetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_volqueta, parent, false);
        return new VolquetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolquetaViewHolder holder, int position) {
        Volqueta volqueta = volquetaList.get(position);

        // Asignar los datos que sí existen
        holder.tvPlaca.setText(volqueta.getPlaca());

        String estado = volqueta.getEstado();
        holder.tvEstado.setText(estado);

        // Cambiar color del estado según el valor de la API
        if (estado != null && estado.equalsIgnoreCase("activo")) {
            // Si el estado es "activo", lo consideramos "Disponible"
            holder.tvEstado.setText("Disponible");
            holder.tvEstado.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
            // Puedes agregar un fondo para que se vea como un tag
            // holder.tvEstado.setBackgroundResource(R.drawable.estado_background_disponible);
        } else {
            // Para cualquier otro estado, como "inactivo" o "en_mantenimiento"
            holder.tvEstado.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    @Override
    public int getItemCount() {
        return volquetaList.size();
    }

    // ViewHolder simplificado
    public static class VolquetaViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlaca, tvEstado;

        public VolquetaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaca = itemView.findViewById(R.id.tv_placa);
            tvEstado = itemView.findViewById(R.id.tv_estado);
        }
    }
}