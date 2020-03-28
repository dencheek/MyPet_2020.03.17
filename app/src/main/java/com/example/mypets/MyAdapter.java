package com.example.mypets;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    // если че лучше ArrayList юзай, а не массив, хотя это дело вкуса
    private List<Animal> animals = new ArrayList<>();

    // в этом методе знакомишь адаптер с вьюхой каждого элемента списка
    // т.е. дата в каждом элементе списка разная, но вьюха одна и та же
    // плюс оборачиваешь во вью холдер, у этой схемы давняя история, пока не заморачивайся почему именно так сделано,
    // потом на словах расскажу
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // здесь мы даем каждой вьюхе данные из массива
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // position - порядковый номер каждого элемента списка возвращает сам адаптер, мы не паримся с этим вопросом
        // и по нему из списка animals мы получаем конкретный Animal для каждой позиции
        Animal animal = animals.get(position);
        holder.tvAnimal.setText(animal.getAnimal());
        holder.tvName.setText(animal.getName());
    }

    // это неоптимальная схема, в больших прилках нужно делать через DiffUtil, чтобы не вся дата обновилась, а только изменения
    public void setData(List<Animal> newAnimals) {
        // очищаем
        animals.clear();
        // добавляем
        animals.addAll(newAnimals);
        // говорим адаптеру, что есть новая дата - перезагрузись
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAnimal;
        public TextView tvName;

        public MyViewHolder(View v) {
            super(v);
            // здесь получаем ссылки на все TextView во вьюхе для списка (та которая item_view в папке res/layout)
            // потом эти ссылки заюзаем в методе onBindViewHolder
            tvAnimal = v.findViewById(R.id.tv_animal);
            tvName = v.findViewById(R.id.tv_name);
        }
    }
}
