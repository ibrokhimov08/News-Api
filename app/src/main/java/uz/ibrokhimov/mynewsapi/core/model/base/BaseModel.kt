package uz.ibrokhimov.mynewsapi.core.model.base

abstract class BaseModel {


    companion object {
        const val TOP_HEAD_LINE = 0
        const val EVERY_THING = 1
    }

    abstract fun getType() :Int

}