package com.example.pedidosapp.ui

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pedidosapp.databinding.ActivityPedidoBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    private val startResultPhoto1 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as Bitmap
                binding.imPhoto1.setImageBitmap(imageBitmap)
            }
        }

    private val startResultPhoto2 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as Bitmap
                binding.imPhoto2.setImageBitmap(imageBitmap)
            }
        }

    private val startResultPhoto3 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as Bitmap
                binding.imPhoto3.setImageBitmap(imageBitmap)
            }
        }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFecha()
        setHora()
        subirPedido()
        photo1()
        photo2()
        photo3()
    }

    private fun photo1() {
        binding.imPhoto1.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startResultPhoto1.launch(takePictureIntent)
                }
            }
        }

    }

    private fun photo2() {
        binding.imPhoto2.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startResultPhoto2.launch(takePictureIntent)
                }
            }
        }
    }

    private fun photo3() {
        binding.imPhoto3.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startResultPhoto3.launch(takePictureIntent)
                }
            }
        }
    }

    private fun subirPedido() {
        binding.btnSubir.setOnClickListener {
            if (comprobarCampos()) ingresarPedido()
        }
    }


    private fun comprobarCampos(): Boolean {

        var cont = 0
        val rut = binding.txtRut.text.toString()
        val ped = binding.txtPedido.text.toString()
        val canArt = binding.txtArt.text.toString()
        val canArtEnt = binding.txtArtEnt.text.toString()
        val detalle = binding.txtDetail.text.toString()


        if (rut.trim().isEmpty()) {
            binding.inputRut.error = "Ingrese un Rut"
        } else {
            binding.inputRut.error = null
            cont += 1
        }

        if (ped.trim().isEmpty()) {
            binding.inputPedido.error = "Ingrese N° Pedido"
        } else {
            binding.inputPedido.error = null
            cont += 1
        }

        if (canArt.trim().isEmpty()) {
            binding.inputArt.error = "Ingrese N° Articulos"
        } else {
            binding.inputArt.error = null
            cont += 1
        }

        if (canArtEnt.trim().isEmpty()) {
            binding.inputArtEnt.error = "Ingrese N° Articulos Entregados"
        } else {
            binding.inputArtEnt.error = null
            cont += 1
        }

        if (detalle.trim().isEmpty()) {
            binding.inputDetail.error = "Ingrese Detalle"
        } else {
            binding.inputDetail.error = null
            cont += 1
        }

        return cont == 5

    }

    private fun ingresarPedido() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Pedido")
            .setMessage("Crear Pedido ${binding.txtPedido.text.toString()} ?")
            .setNegativeButton("No") { _, _ ->
                binding.txtArt.setText("")
            }
            .setPositiveButton("Si") { _, _ ->
                Toast.makeText(this, "Pedido Creado", Toast.LENGTH_LONG).show()
            }
        dialog.create()
        dialog.show()
    }

    private fun setHora() {
        val sdf5 = SimpleDateFormat("H:mm")
        binding.txtHora.setText(sdf5.format(Date()))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setFecha() {
        binding.txtFecha.setText(LocalDate.now().toString())
    }
}