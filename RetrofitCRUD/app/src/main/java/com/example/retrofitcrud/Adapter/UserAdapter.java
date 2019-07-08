package com.example.retrofitcrud.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitcrud.Model.UserModel;
import com.example.retrofitcrud.R;
import com.example.retrofitcrud.ResponseModel.DeleteResponse;
import com.example.retrofitcrud.ResponseModel.UpdateResponse;
import com.example.retrofitcrud.Retrofit.RetrofitClient;
import com.example.retrofitcrud.Retrofit.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder> {

    private Context context;
    private List<UserModel> userModels;


    public UserAdapter(Context context, List<UserModel> userModels) {
        this.context = context;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_row_list,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        final String studid = userModels.get(i).getStudent_id();

        holder.stud_id.setText(userModels.get(i).getStudent_id());
        holder.stud_name.setText(userModels.get(i).getStudent_name());
        holder.stud_email.setText(userModels.get(i).getStudent_email());
        holder.stud_address.setText(userModels.get(i).getStudent_address());
        holder.stud_pno.setText(userModels.get(i).getStudent_phone());
        holder.stud_div.setText(userModels.get(i).getStudent_class());
        holder.gender.setText(userModels.get(i).getGender());
        holder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_student(userModels.get(i),studid);
            }
        });

        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove_student(holder,studid);
            }
        });
    }

    private void update_student(final UserModel userModel, final String studid) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.update_user, null);
        builder.setView(view);

        final TextInputEditText update_name,update_email,update_city,update_phone;
        Button update_user;

        update_name = view.findViewById(R.id.update_name);
        update_email = view.findViewById(R.id.update_email);
        update_city = view.findViewById(R.id.update_city);
        update_phone = view.findViewById(R.id.update_phone);
        update_user = view.findViewById(R.id.update_user);

        update_name.setText(userModel.getStudent_name());
        update_email.setText(userModel.getStudent_email());
        update_city.setText(userModel.getStudent_address());
        update_phone.setText(userModel.getStudent_phone());


        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        update_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = update_name.getText().toString().trim();
                String email = update_email.getText().toString().trim();
                String city = update_city.getText().toString().trim();
                String phone = update_phone.getText().toString().trim();


                RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);
                Call<UpdateResponse> updateResponseCall = retrofitInterface.UPDATE_RESPONSE_CALL(studid,name,email,city,phone);

                updateResponseCall.enqueue(new Callback<UpdateResponse>() {
                    @Override
                    public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {

                        UpdateResponse updateResponse = response.body();
                        Toast.makeText(context,updateResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UpdateResponse> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("Failer",""+t.getMessage());
                    }
                });
                notifyDataSetChanged();
                alertDialog.dismiss();
            }

        });


    }
    
    private void remove_student(Holder holder,String id){

        RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);

        Call<DeleteResponse> deleteResponseCall = retrofitInterface.DELETE_RESPONSE_CALL(id);

        deleteResponseCall.enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                DeleteResponse deleteResponse = response.body();

                Toast.makeText(context,deleteResponse.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView stud_id,stud_name,stud_email,stud_address,stud_pno,stud_div,gender;
        AppCompatImageView btn_update,btn_remove;

        public Holder(@NonNull View itemView) {
            super(itemView);

            stud_id = itemView.findViewById(R.id.stud_id);
            stud_name = itemView.findViewById(R.id.stud_name);
            stud_email = itemView.findViewById(R.id.stud_email);
            stud_address = itemView.findViewById(R.id.stud_address);
            stud_pno = itemView.findViewById(R.id.student_pno);
            stud_div = itemView.findViewById(R.id.stud_div);
            gender = itemView.findViewById(R.id.gender);
            btn_update = itemView.findViewById(R.id.btn_update);
            btn_remove = itemView.findViewById(R.id.btn_remove);
        }
    }
}
