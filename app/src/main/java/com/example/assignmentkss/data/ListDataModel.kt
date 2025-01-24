package com.example.assignmentkss.data

import com.google.gson.annotations.SerializedName

data class ItemResponse(

    @SerializedName("success"       ) var success       : Int?                     = null,
    @SerializedName("StockDataList" ) var StockDataList : ArrayList<ListDataModel> = arrayListOf()
)

data class MergedTagnoPcs (

    @SerializedName("tagno" ) var tagno : String? = null,
    @SerializedName("pcs"   ) var pcs   : String? = null,
    @SerializedName("gross" ) var gross : String? = null

)

data class ListDataModel (

    @SerializedName("itemName"         ) var itemName       : String?                   = null,
    @SerializedName("metaltype"        ) var metaltype      : String?                   = null,
    @SerializedName("count"            ) var count          : String?                   = null,
    @SerializedName("itemId"           ) var itemId         : String?                   = null,
    @SerializedName("transkey"         ) var transkey       : String?                   = null,
    @SerializedName("is_tagalpha"      ) var isTagalpha     : String?                   = null,
    @SerializedName("type"             ) var type           : String?                   = null,
    @SerializedName("merged_tagno_pcs" ) var mergedTagnoPcs : ArrayList<MergedTagnoPcs> = arrayListOf()

)

//data class ListDataModel(
//    @SerializedName("id"          ) var id          : String? = null,
//    @SerializedName("name"        ) var name        : String? = null,
//    @SerializedName("description" ) var description : String? = null
//)
