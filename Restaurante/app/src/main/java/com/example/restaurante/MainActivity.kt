package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    // Este comando vai inicializar a variável depois da sua declaração.
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // O comando 'inflate' ira criar uma view a partir do arquivo XML.
        binding = ActivityMainBinding.inflate(layoutInflater)
       // Parâmetro do método onCreate.
        super.onCreate(savedInstanceState)
        // Mostra o layout da tela.
        setContentView(binding.root)

       // Chama a variável username.
        val username = intent.extras?.getString("username")
       // Condição para a variável username.
        if(!username.isNullOrEmpty()){
            // O comando escreverá "Olá username" se a condição for realizada.
            binding.textOla.setText("Olá $username")
        }

        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }


        binding.checkPizza.setOnClickListener {
            // Condição para as variáveis da pizza. Se o ícone for selecionado a quantidade exibida muda no aplicativo para '1'...
            if(binding.checkPizza.isChecked()){
                // Este comando muda o número da variável QuantidadePizza para 1 se a pizza for selecionada.
                binding.editQuantidadePizza.setText("1")
                // Este comando tornará o preço da pizza visível ao usuário.
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                 //...e caso não for, permanece 0.
                binding.editQuantidadePizza.setText("0")
                // Este comando fará com que o preço não seja mais visível ao usuário.
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
        // Condição para as variáveis da salada. Idênticas às da pizza.
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                // faz o mesmo que o editQuantidadePizza.
                binding.editQuantidadeSalada.setText("1")
                // faz o mesmo que o visibility da pizza.
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
        // Condição para as variáveis do hambúrguer. Os comandos funcionam de forma idêntica aos da pizza.
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                // faz o mesmo que o editQuantidadePizza.
                binding.editQuantidadeHamburguer.setText("1")
                // faz o mesmo que o visibility da pizza.
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
