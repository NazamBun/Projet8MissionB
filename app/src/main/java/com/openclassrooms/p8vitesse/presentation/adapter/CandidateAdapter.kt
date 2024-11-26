package com.openclassrooms.p8vitesse.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.arista.R
import com.openclassrooms.arista.databinding.ItemCandidateBinding
import com.openclassrooms.p8vitesse.domain.model.Candidate

class CandidateAdapter(
    private var candidates: List<Candidate>,
    private val onItemClick: (Candidate) -> Unit
) : RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>() {

    /**
     * ViewHolder pour chaque item candidat.
     * Il permet de réutiliser les vues pour chaque élément affiché dans la RecyclerView.
     */
    class CandidateViewHolder(private val binding: ItemCandidateBinding, private val onItemClick: (Candidate) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Lie les données d'un candidat aux vues.
         *
         * @param candidate Le candidat dont les données doivent être liées aux vues.
         */
        fun bind(candidate: Candidate) {
            // Placeholder pour la photo (tu pourrais remplacer cette ligne par un chargement d'image réel via une bibliothèque comme Glide ou Picasso)
            binding.ivCandidatePhoto.setImageResource(R.drawable.ic_placeholder)
            // Affiche le prénom et le nom du candidat
            binding.tvCandidateName.text = "${candidate.firstName} ${candidate.lastName}"
            // Affiche les notes du candidat
            binding.tvCandidateNote.text = candidate.notes

            // Gère le clic sur un item (par exemple pour naviguer vers l'écran de détail)
            binding.root.setOnClickListener {
                onItemClick(candidate)
            }
        }

    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        // Crée la vue à partir du layout item_candidate.xml en utilisant ViewBinding
        val binding = ItemCandidateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CandidateViewHolder(binding, onItemClick)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int = candidates.size

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        holder.bind(candidates[position])
    }

    /**
     * Met à jour la liste des candidats et notifie la RecyclerView que les données ont changé.
     *
     * @param newCandidates La nouvelle liste des candidats.
     */
    fun updateCandidates(newCandidates: List<Candidate>) {
        candidates = newCandidates
        notifyDataSetChanged()
    }
}