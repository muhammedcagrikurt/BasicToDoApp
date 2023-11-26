package com.kurt.todo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.kurt.todo.data.entity.Todo;
import com.kurt.todo.databinding.CardTasarimBinding;
import com.kurt.todo.ui.fragment.AnasayfaFragmentDirections;
import com.kurt.todo.ui.viewmodel.AnasayfaViewModel;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.CardTasarimHolder> {
    private List<Todo> todoList;
    private Context context;
    private AnasayfaViewModel viewModel;

    public TodoAdapter(List<Todo> todoList, Context context, AnasayfaViewModel viewModel) {
        this.todoList = todoList;
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardTasarimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(context),parent,false);
        return new CardTasarimHolder(binding) ;
    }


    @Override
    public void onBindViewHolder(@NonNull CardTasarimHolder holder, int position) {
        Todo todo = todoList.get(position);
        CardTasarimBinding tasarimBinding = holder.cardTasarimBinding;
        tasarimBinding.textViewToDo.setText(todo.getName());
        tasarimBinding.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,"Not silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",view1 -> {
                        viewModel.sil(todo.getId());
                    })
                    .show();
        });
        tasarimBinding.cardView.setOnClickListener(view -> {
            AnasayfaFragmentDirections.AnasayfaDetayGecis anasayfaDetayGecis = AnasayfaFragmentDirections.anasayfaDetayGecis(todo);
            Navigation.findNavController(view).navigate(anasayfaDetayGecis);
        });


    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class CardTasarimHolder extends RecyclerView.ViewHolder{
        private CardTasarimBinding cardTasarimBinding;

         public CardTasarimHolder(CardTasarimBinding cardTasarimBinding) {
             super(cardTasarimBinding.getRoot());
             this.cardTasarimBinding=cardTasarimBinding;
         }
     }
}
