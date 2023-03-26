package com.raquel.projetointegrador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {
    private ArrayList<LivroLista> livroLista;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagem;
        private TextView titulo;
        private TextView autor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imagem);
            titulo = itemView.findViewById(R.id.titulo);
            autor = itemView.findViewById(R.id.autor);
        }
    }

    public LivroAdapter(ArrayList<LivroLista> list){
        livroLista = list;
    }

    public void setFilteredList(ArrayList<LivroLista> filteredList){
        this.livroLista = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livro_exemplo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LivroLista item = livroLista.get(position);

        holder.imagem.setImageResource(item.getImagem());
        holder.titulo.setText(item.getTitulo());
        holder.autor.setText(item.getAutor());
    }

    @Override
    public int getItemCount() {
        return livroLista.size();
    }
}
