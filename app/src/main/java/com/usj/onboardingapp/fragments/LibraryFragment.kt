package com.usj.onboardingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.usj.onboardingapp.adapters.LibraryAdapter
import com.usj.onboardingapp.R
import com.usj.onboardingapp.utils.managers.SettingsManager
import com.usj.onboardingapp.viewmodels.LibraryViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [LibraryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LibraryFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val libraryViewModel: LibraryViewModel =
            ViewModelProvider(this)[LibraryViewModel::class.java]
        recyclerView = view.findViewById(R.id.libraryRv)
        setupRVLayoutManager()
        val divider: DividerItemDecoration =
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(divider)

        libraryViewModel.libraryItems.observe(viewLifecycleOwner) { libraryItems ->
            recyclerView.adapter = LibraryAdapter(libraryItems)
        }
        libraryViewModel.fetchLibraryItems()
        setupMenuProvider()
    }

    private fun setupRVLayoutManager() {
        val layoutMode = SettingsManager.getLayoutMode(requireContext())
        recyclerView.layoutManager =
            if (layoutMode == SettingsManager.LAYOUT_MODE_LIST) LinearLayoutManager(
                requireContext()
            )
            else GridLayoutManager(
                requireContext(),
                2
            )
    }

    private fun setupMenuProvider() {
        val menuProvider: MenuProvider = object : MenuProvider {
            override fun onCreateMenu(
                menu: Menu,
                menuInflater: MenuInflater
            ) {
                menuInflater.inflate(R.menu.layout_mode_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                val chosenMode = when (menuItem.itemId) {
                    R.id.layout_list_option -> SettingsManager.LAYOUT_MODE_LIST
                    R.id.layout_grid_option -> SettingsManager.LAYOUT_MODE_GRID
                    else -> return false
                }
                SettingsManager.saveLayoutMode(
                    requireContext(),
                    chosenMode
                )
                setupRVLayoutManager()
                return true
            }
        }
        requireActivity().addMenuProvider(menuProvider)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LibraryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = LibraryFragment()
    }
}