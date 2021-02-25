package typealiasapp.ca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import typealiasapp.ca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainAdapter = MainAdapter(
                listOf(
                        "Kotlin",
                        "Java",
                        "PHP",
                        "JavaScript",
                        "Python",
                        "Cobol",
                        "Visual Basic"
                )
        )

        mainAdapter.onItemClicked = { language ->
            Toast.makeText(this, language, Toast.LENGTH_LONG).show()
        }

        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }
}