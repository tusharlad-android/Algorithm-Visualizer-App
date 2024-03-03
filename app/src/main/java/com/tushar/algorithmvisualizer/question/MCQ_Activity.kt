package com.tushar.algorithmvisualizer.question

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat



import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.tushar.algorithmvisualizer.MainActivity

import com.tushar.algorithmvisualizer.R


import kotlin.random.Random


class MCQ_Activity:AppCompatActivity() {
    var timer = 360
    lateinit var progressBar: ProgressBar
    val list=ArrayList<Model>()
    var index=0;
    lateinit var model: Model
    lateinit var txtQuestion: TextView
    lateinit var txtoptionA: TextView
    lateinit var txtoptionB:TextView
    lateinit var txtoptionC:TextView
    lateinit var txtoptionD:TextView
    lateinit var btnnext: LinearLayout
    lateinit var btnQuestion:CardView
    lateinit var btnoptionA: CardView
    lateinit var btnoptionB:CardView
    lateinit var btnoptionC:CardView
    lateinit var btnoptionD:CardView
    lateinit var backarrow:ImageView
    lateinit var Exit:TextView
    var correctCount:Int = 0
    var wrongCount=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mcqmain)
        progressBar = findViewById(R.id.progressbar)
        txtQuestion=findViewById(R.id.txtquestion_name)
        txtoptionA=findViewById(R.id.option_a)
        txtoptionB=findViewById(R.id.option_b)
        txtoptionC=findViewById(R.id.option_c)
        txtoptionD=findViewById(R.id.option_d)
        btnnext=findViewById(R.id.btnNext)
        btnQuestion=findViewById(R.id.btnquestion)
        btnoptionA=findViewById(R.id.btn_a)
        btnoptionB=findViewById(R.id.btn_b)
        btnoptionC=findViewById(R.id.btn_c)
        btnoptionD=findViewById(R.id.btn_d)

        val countdowntimer = object : CountDownTimer(3600000, 1000) {
            override fun onTick(p0: Long) {
                timer = timer - 1
                val progress = (timer.toFloat() / 360f * 100f).toInt()
                progressBar.progress = progress
            }


            override fun onFinish() {
                val builder: AlertDialog.Builder = AlertDialog.Builder(applicationContext)
                builder
                    .setMessage("Your Score is"+correctCount+"/20")
                    .setTitle("Time Up")
                    .setPositiveButton("Retest") { dialog, which ->
                        val intent= Intent(applicationContext,this::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("Exit") { dialog, which ->
                        val intent=Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                    }

                val dialog: AlertDialog = builder.create()
                dialog.show()

            }
        }.start()

        list.add(Model("Which data structure is used for implementing recursion?","Stack","Queue","List","Array","Stack"))
        list.add(Model("The data structure required to check whether an expression contains a balanced parenthesis is?","Queue","Stack","Tree","Array","Stack"))
        list.add(Model("Which data structure is needed to convert infix notation to postfix notation?","Tree","Branch","Stack","Queue","Stack"))
        list.add(Model("What is the value of the postfix expression 6 3 2 4 + – *?","74","-18","22","40","-18"))

        list.add(Model("What data structure would you mostly likely see in non recursive implementation of a recursive algorithm?","Stack","Linked List","Tree","Queue","Stack"))
        list.add(Model("The data structure required for Breadth First Traversal on a graph is?","Array","Stack","Tree","Queue","Queue"))
        list.add(Model("The prefix form of A-B/ (C * D ^ E) is?","-A/B*C^DE"," -A/BC*^DE","-ABCD*^DE","-/*^ACBDE","-A/B*C^DE"))
        list.add(Model("Which data structure is based on the Last In First Out (LIFO) principle?","Tree","Linked List","Stack","Queue","Stack"))

        list.add(Model("Which of the following tree data structures is not a balanced binary tree?","Splay tree","B-tree","AVL tree","Red-black tree","B-tree"))
        list.add(Model("Which of the following data structures can be used for parentheses matching?","n-ary tree","queue","priority queue","stack","stack"))
        list.add(Model("Which algorithm is used in the top tree data structure?","Backtracking","Divide and Conquer","Branch","Greedy","Divide and Conquer"))
        list.add(Model("Which of the following is the most widely used external memory data structure?","B-tree","Red-black tree","AVL tree"," Both AVL tree and Red-black tree","B-tree"))

        list.add(Model("Which of the following is also known as Rope data structure?","Linked List","Array","String","Cord","Cord"))
        list.add(Model("Which of the following data structure can provide efficient searching of the elements?","binary search tree","unordered lists","2-3 tree","treap","2-3 tree"))
        list.add(Model("What is the time complexity for searching a key or integer in Van Emde Boas data structure?","O (M!)","O (log M!)","O (log (log M))","O (M2)","O (log (log M))"))
        list.add(Model("The optimal data structure used to solve Tower of Hanoi is _________","Tree","Heap","Priority queue","Stack","Stack"))
        list.add(Model("Which is the most appropriate data structure for reversing a word?","stack","queue","graph","tree","stack"))

        list.add(Model("Which of the following is the simplest data structure that supports range searching?","AA-trees","K-d trees","Heaps","binary search trees","Heaps"))

        list.add(Model("Which type of data structure is a ternary heap?","Hash","Array","Priority Stack","Priority Queue","Priority Queue"))

        list.add(Model("A data structure in which elements can be inserted or deleted at/from both ends but not in the middle is?","Priority queue","Dequeue","Circular queue","Queue","Dequeue"))

        list.add(Model("In simple chaining, what data structure is appropriate?","Doubly linked list","Circular linked list","Singly linked list","Binary trees","Doubly linked list"))

        list.add(Model("Which one of the following is the process of inserting an element in the stack?","Insert","Add","Push","None of the above","Push"))
        list.add(Model("When the user tries to delete the element from the empty stack then the condition is said to be a ____","Underflow","Garbage collection","Overflow","None of the above","Underflow"))
        list.add(Model("Which data structure is mainly used for implementing the recursive algorithm?","Queue","Stack","Binary tree","Linked list","Stack"))
        list.shuffle()
        model=list.get(index)

        setAllData()



            onclicklistener()
            btnnext.setOnClickListener {
                if(index==20){
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                    builder
                        .setMessage("Your Score is"+ correctCount+"/20")
                        .setTitle("Test Over")
                        .setPositiveButton("Retest") { dialog, which ->
                            val intent= Intent(this,this::class.java)
                            startActivity(intent)
                        }
                        .setNegativeButton("Exit") { dialog, which ->
                            val intent=Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }

                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
                index++
                btnoptionA.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                btnoptionB.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                btnoptionC.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                btnoptionD.setBackgroundColor(ContextCompat.getColor(this, R.color.white))

                model = list.get(index)
                setAllData()


            }









    }

    private fun setAllData() {
        txtQuestion.setText(model.getquestion())
        txtoptionA.setText(model.getoA())
        txtoptionB.setText(model.getoB())
        txtoptionC.setText(model.getoC())
        txtoptionD.setText(model.getoD())
    }
    @SuppressLint("ResourceAsColor")
    private fun onclicklistener() {

        // option A
        btnoptionA.setOnClickListener {
            if (model.getoA() == model.getans()) {
                correctCount++
                btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
            }




                else{
                    wrongCount++
                if(model.getoB()==model.getans()){
                        btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                        btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                    }
                if(model.getoC()==model.getans()){
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoD()==model.getans()){
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                } 
                }

            }
        // option B
        btnoptionB.setOnClickListener {
            if (model.getoB() == model.getans()) {
                correctCount++
                btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
            }




            else{
                wrongCount++
                if(model.getoC()==model.getans()){
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoD()==model.getans()){
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoA()==model.getans()){
                    btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
            }

        }
        // option D
        btnoptionD.setOnClickListener {
            if (model.getoD() == model.getans()) {
                correctCount++
                btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
            }




            else{
                wrongCount++
                if(model.getoB()==model.getans()){
                    btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoC()==model.getans()){
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoA()==model.getans()){
                    btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
            }

        }
        btnoptionC.setOnClickListener {
            if (model.getoD() == model.getans()) {
                correctCount++
                btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
            }




            else{
                wrongCount++
                if(model.getoB()==model.getans()){
                    btnoptionB.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoD()==model.getans()){
                    btnoptionD.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
                if(model.getoA()==model.getans()){
                    btnoptionA.setBackgroundColor(ContextCompat.getColor(this,R.color.correctans))
                    btnoptionC.setBackgroundColor(ContextCompat.getColor(this,R.color.wrongans))
                }
            }

        }

        }

   


}
    





