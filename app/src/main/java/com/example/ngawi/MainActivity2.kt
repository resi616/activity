package com.example.ngawi

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.Calendar

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    lateinit var etTanggal: EditText

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val  btnSimpan: Button = findViewById(R.id.btn_simpan)
        btnSimpan.setOnClickListener(this)

        etTanggal = findViewById(R.id.et_input_tanggal)
        etTanggal.setOnClickListener{
            val c =Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                    this,
                    {view, year, monthOfYear, dayOfMonth ->
                        val dat = (dayOfMonth.toString() + "-" + year)
                        etTanggal.setText(dat)
                    },
                    year,
                    month,
                    day
            )

            datePickerDialog.show()
        }

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btn_simpan  -> {
                val etNamaDepan:EditText = findViewById(R.id.et_input_namaDepan)
                val etNamaBelakang:EditText = findViewById(R.id.et_input_namaBelakang)
                val etTanggal : EditText = findViewById(R.id.et_input_tanggal)
                val etAlamat :EditText = findViewById(R.id.et_input_alamat)
                val etNomor :EditText = findViewById(R.id.et_input_nomor)

                val tvNama : TextView= findViewById(R.id.tv_output_nama)
                val tvTanggal: TextView= findViewById(R.id.tv_output_tanggal)
                val tvAlamat: TextView= findViewById(R.id.tv_output_alamat)
                val tvNomor: TextView= findViewById(R.id.tv_output_nomor)

                val textNama = "Nama:${etNamaDepan.getText().toString()}${etNamaBelakang.getText().toString()}"
                val textTanggal = "Tanggal Lahir. ${etTanggal.getText().toString()}"
                val textAlamat = "Alamat: ${etAlamat.getText().toString()}"
                val textNomor = "Nomor Telp: ${etNomor.getText().toString()}"

                tvNama.text = textNama
                tvTanggal.text =textTanggal
                tvAlamat.text =textAlamat
                tvNomor.text = textNomor

            }
        }
    }
}