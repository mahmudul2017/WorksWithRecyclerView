package com.example.test12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test12.adapter.ContactAdapter;
import com.example.test12.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone;
    Button btnSave;
    RecyclerView recyclerView;
    String name, phone;
    ContactAdapter contactAdapter;
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnSave);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        contacts = new ArrayList<>();
        contactAdapter = new ContactAdapter(MainActivity.this, contacts);
        recyclerView.setAdapter(contactAdapter);

        contactAdapter.setOnClickListener(new ContactAdapter.clickListener() {
            @Override
            public void onClick(int position, View view) {
                Contact nameShow = contacts.get(position);
                String collectName = nameShow.getName();
                Toast.makeText(MainActivity.this, "Name is : "+ collectName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnClick(View view) {
        name = etName.getText().toString();
        phone = etPhone.getText().toString();
        Contact contact = new Contact(name, phone);
     //   contacts = new ArrayList<>();
        contacts.add(contact);
     //   contactAdapter = new ContactAdapter(MainActivity.this, contacts);
     //   recyclerView.setAdapter(contactAdapter);
        contactAdapter.updateData(contacts);
    }
}
