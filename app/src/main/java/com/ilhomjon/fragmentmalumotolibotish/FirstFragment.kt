package com.ilhomjon.fragmentmalumotolibotish

import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.labo.kaji.fragmentanimations.CubeAnimation
import com.labo.kaji.fragmentanimations.MoveAnimation
import kotlinx.android.synthetic.main.fragment_first.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_first, container, false)

        setHasOptionsMenu(true)

        root.btn.setOnClickListener {
            val text = root.edt.text.toString()
            val secondFragment = SecondFragment.newInstance(text)

//            val bundle = Bundle()
//            bundle.putString("userName", text)

            fragmentManager?.beginTransaction()?.replace(R.id.container, secondFragment)?.addToBackStack(secondFragment.toString())?.commit()
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
         R.id.menu_add ->
            Toast.makeText(root.context, "Click", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}