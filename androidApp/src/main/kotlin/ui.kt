package jp.moneytree

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainApplication : Application() {
  override fun onCreate() {
    super.onCreate()
  }
}

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    title = "Hackday 2019 Apr"

    setContentView(R.layout.activity_main)
    findViewById<RecyclerView>(R.id.list).apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      addItemDecoration(DividerItemDecoration(
        this.context,
        (layoutManager as LinearLayoutManager).orientation)
      )
      adapter = EraAdapter(EraLoader.loadEras())
    }
  }
}

class EraAdapter(
  private val eras: List<Era>
) : RecyclerView.Adapter<EraAdapter.ViewHolder>() {

  override fun getItemCount(): Int = eras.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
    LayoutInflater
      .from(parent.context)
      .inflate(R.layout.row_era, parent, false)
      .let { ViewHolder(it) }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.apply {
      nameView.text = eras[position].name
      nameKanjiView.text = eras[position].nameKanji
    }
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameView = view.findViewById<TextView>(R.id.name)
    val nameKanjiView = view.findViewById<TextView>(R.id.nameKanji)
  }
}
