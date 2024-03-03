package com.tushar.algorithmvisualizer.question

class Model {
    var question:String
    var oA:String
    var oB:String
    var oC:String
    var oD:String
    var ans:String

    constructor(question: String, oA: String, oB: String, oC: String, oD: String, ans: String) {
        this.question = question
        this.oA = oA
        this.oB = oB
        this.oC = oC
        this.oD = oD
        this.ans = ans

    }
    fun getquestion(): String {
        return this.question
    }
    fun getoA(): String {
        return this.oA
    }
    fun getoB(): String {
        return this.oB
    }
    fun getoC(): String {
        return this.oC
    }
    fun getoD(): String {
        return this.oD
    }
    fun getans(): String {
        return this.ans
    }
    fun setquestion(question: String) {
        this.question=question
    }
    fun setoA(oA:String) {
        this.oA=oA
    }
    fun setoB(oB: String) {
        this.oB=oB
    }
    fun setoC(oC: String) {
        this.oC=oC
    }
    fun setoD(oD: String) {
        this.oD=oD
    }
    fun setans(ans: String) {
        this.ans=ans
    }
    


}