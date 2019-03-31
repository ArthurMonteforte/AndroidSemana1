package br.com.paulosalvatore.pagseguroandroidturmab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ProgrammingLanguageAdapter
        extends RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder> {
    private final View.OnClickListener listener;
    private List<ProgrammingLanguage> programmingLanguages;

    public ProgrammingLanguageAdapter(List<ProgrammingLanguage> programmingLanguages, View.OnClickListener listener) {
        this.programmingLanguages = programmingLanguages;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.programming_language, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProgrammingLanguage programmingLanguage = programmingLanguages.get(position);
        holder.bindView(programmingLanguage, listener);
    }

    @Override
    public int getItemCount() {
        return programmingLanguages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        void bindView(ProgrammingLanguage programmingLanguage, View.OnClickListener listener) {
            // Presentation Logic
            // itemView -> Layout XML
            // programmingLanguage -> Data

            ImageView ivMain = itemView.findViewById(R.id.ivMain);
            TextView tvTitle = itemView.findViewById(R.id.tvTitle);
            TextView tvLaunchYear = itemView.findViewById(R.id.tvLaunchYear);
            TextView tvDescription = itemView.findViewById(R.id.tvDescription);

            ivMain.setImageResource(programmingLanguage.getImageResourceId());
            tvTitle.setText(programmingLanguage.getTitle());
            tvLaunchYear.setText(String.valueOf(programmingLanguage.getYear()));
            tvDescription.setText(programmingLanguage.getDescription());

            itemView.setOnClickListener(listener);
        }
    }
}
