package com.example.shopingapp.ui.home.fragment

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.repository.HomeRepository
import com.example.shopingapp.utils.PrefUtils
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: HomeRepository,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

//    private val _bestSeller: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val bestSeller: LiveData<ProductListModel>
//        get() = _bestSeller
//
//    private val _homeBeauty: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val homeBeauty: LiveData<ProductListModel>
//        get() = _homeBeauty
//
//    private val _homeFurniture: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val homeFurniture: LiveData<ProductListModel>
//        get() = _homeFurniture
//
//
//    private val _homeDecoration: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val homeDecoration: LiveData<ProductListModel>
//        get() = _homeDecoration
//
//    private val _homeAndLiving: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val homeAndLiving: LiveData<ProductListModel>
//        get() = _homeAndLiving
//
//    private val _categories: MutableLiveData<CategoriesModel> =
//        MutableLiveData<CategoriesModel>()
//    val categories: LiveData<CategoriesModel>
//        get() = _categories
//
//    private val _searchAutoComplete: MutableLiveData<List<SearchAutoCompleteModel.Data>> =
//        MutableLiveData<List<SearchAutoCompleteModel.Data>>()
//    val searchAutoComplete: LiveData<List<SearchAutoCompleteModel.Data>>
//        get() = _searchAutoComplete
//
//    private val _videoUrl: MutableLiveData<CarousalHomeModel> =
//        MutableLiveData<CarousalHomeModel>()
//    val videoUrl: LiveData<CarousalHomeModel>
//        get() = _videoUrl
//
//    private val _meetTheMaker: MutableLiveData<MeetTheMakerModel> =
//        MutableLiveData<MeetTheMakerModel>()
//    val meetTheMaker: LiveData<MeetTheMakerModel>
//        get() = _meetTheMaker
//
//    private val _youMayLikeThis: MutableLiveData<ProductListModel> =
//        MutableLiveData<ProductListModel>()
//    val youMayLikeThis: LiveData<ProductListModel>
//        get() = _youMayLikeThis
//
//    private val _designerLabesList: MutableLiveData<List<String>> =
//        MutableLiveData<List<String>>()
//    val designerLabesList: LiveData<List<String>>
//        get() = _designerLabesList
//
//    private val _customerWhiteLabesList: MutableLiveData<List<String>> =
//        MutableLiveData<List<String>>()
//    val customerWhiteLabesList: LiveData<List<String>>
//        get() = _customerWhiteLabesList
//
//    private val _rowMaterialsList: MutableLiveData<List<String>> =
//        MutableLiveData<List<String>>()
//    val rowMaterialsList: LiveData<List<String>>
//        get() = _rowMaterialsList
//
//    private val _aboutpage: MutableLiveData<AboutModel> =
//        MutableLiveData<AboutModel>()
//    val aboutpage: LiveData<AboutModel>
//        get() = _aboutpage


//    init {
//        callMainCategoryList()
//        callBestSeller()
//        callHomeAndLiving()
//        callMeetTheMaker()
//        callCarousalImages()
//        callYouMayLikeThis()
//        callHomeVideo()
//        callBeauty()
//        callFurniture()
//        callHomeDecoration()
//        callAbout()
//    }

//    fun callBestSeller() {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_PRODUCT_BY_DISPLAY_FLAGS)
//                inputParam.addProperty(Constant.REQUEST_DISPLAYFLAGS, Constant.REQUEST_BEST_SELLER)
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callProducts(inputParam)
//                if(apiResponse.data.size > 0) {
//                    for (i in apiResponse.data.indices) {
//                        apiResponse.data.get(i).usedFor = Constant.REQUEST_BEST_SELLER
//                    }
//                }
//                _isViewLoading.postValue(false)
//                _bestSeller.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//    }
//
//    fun callMeetTheMaker(): LiveData<MeetTheMakerModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GET_ASSET_BY_NAME)
//                inputParam.addProperty(Constant.REQUEST_NAME, Constant.REQUEST_MEET_THE_MAKER)
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callMeetTheMaker(inputParam)
//                _isViewLoading.postValue(false)
//                _meetTheMaker.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _meetTheMaker
//    }
//
//    fun callHomeAndLiving(): LiveData<ProductListModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_PRODUCT_BY_DISPLAY_FLAGS)
//                inputParam.addProperty(Constant.REQUEST_DISPLAYFLAGS, Constant.REQUEST_HOME_MADE)
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callProducts(inputParam)
//                if(apiResponse.data.size > 0) {
//                    for (i in apiResponse.data.indices) {
//                        apiResponse.data.get(i).usedFor = Constant.REQUEST_HOME_MADE
//                    }
//                }
//                _isViewLoading.postValue(false)
//                _homeAndLiving.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _homeAndLiving
//    }
//
//    fun callYouMayLikeThis(): LiveData<ProductListModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_PRODUCT_BY_DISPLAY_FLAGS)
//                inputParam.addProperty(Constant.REQUEST_DISPLAYFLAGS, Constant.REQUEST_YOU_MAY_LIKE_THIS)
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callProducts(inputParam)
//                _isViewLoading.postValue(false)
//                _youMayLikeThis.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _youMayLikeThis
//    }
//
//    fun updateBestSellerFavourite(position : Int, productid: Int) {
//        val model : ProductListModel = bestSeller.value!!
//        if(model.data[position].favourite == null) {
//            model.data[position].favourite = "TESTING"
//            callAddRemoveFavourite(productid,0)
//        } else {
//            model.data[position].favourite = null
//            callAddRemoveFavourite(productid,1)
//        }
//        _bestSeller.postValue(model)
//    }
//
//    fun updateHomeMadeFavourite(position : Int, productid: Int) {
//        val model : ProductListModel = homeAndLiving.value!!
//        if(model.data[position].favourite == null) {
//            model.data[position].favourite = "TESTING"
//            callAddRemoveFavourite(productid,0)
//        } else {
//            model.data[position].favourite = null
//            callAddRemoveFavourite(productid,1)
//        }
//        _homeAndLiving.postValue(model)
//    }
//
//    fun updateBeautyFavourite(position : Int, productid: Int) {
//        val model : ProductListModel = _homeBeauty.value!!
//        if(model.data[position].favourite == null) {
//            model.data[position].favourite = "TESTING"
//            callAddRemoveFavourite(productid,0)
//        } else {
//            model.data[position].favourite = null
//            callAddRemoveFavourite(productid,1)
//        }
//        _homeBeauty.postValue(model)
//    }
//
//    fun updateFurnitureFavourite(position : Int, productid: Int) {
//        val model : ProductListModel = _homeFurniture.value!!
//        if(model.data[position].favourite == null) {
//            model.data[position].favourite = "TESTING"
//            callAddRemoveFavourite(productid,0)
//        } else {
//            model.data[position].favourite = null
//            callAddRemoveFavourite(productid,1)
//        }
//        _homeFurniture.postValue(model)
//    }
//
//    fun updateHomeDecorationFavourite(position : Int, productid: Int) {
//        val model : ProductListModel = _homeDecoration.value!!
//        if(model.data[position].favourite == null) {
//            model.data[position].favourite = "TESTING"
//            callAddRemoveFavourite(productid,0)
//        } else {
//            model.data[position].favourite = null
//            callAddRemoveFavourite(productid,1)
//        }
//        _homeDecoration.postValue(model)
//    }
//
//    fun callCarousalImages() {
//        Coroutines.main {
//            try {
//                _isViewLoading.postValue(true)
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GET_ASSET_BY_NAME)
//                inputParam.addProperty(Constant.REQUEST_NAME, Constant.REQUEST_CAROUSAL_IMAGES)
//                val apiResponse = repository.callCarousalImages(inputParam)
//                if(apiResponse.status) {
//                    for( i in apiResponse.data.indices) {
//                        when {
//                            apiResponse.data[i].assetcode.equals(Constant.KEY_DESIGN_LABLES) -> {
//                                val arr:List<String> = apiResponse.data.get(i).imagepath.split(",")
//                                _designerLabesList.postValue(arr)
//                            }
//                            apiResponse.data[i].assetcode.equals(Constant.KEY_CUSTOMIZE_WHITE_LABLES) -> {
//                                val arr:List<String> = apiResponse.data.get(i).imagepath.split(",")
//                                _customerWhiteLabesList.postValue(arr)
//                            }
//                            apiResponse.data[i].assetcode.equals(Constant.KEY_RAW_MATERIALS) -> {
//                                val arr:List<String> = apiResponse.data.get(i).imagepath.split(",")
//                                _rowMaterialsList.postValue(arr)
//                            }
//                        }
//                    }
//                }
//                _isViewLoading.postValue(false)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//    }
//
//    fun callHomeVideo(): LiveData<CarousalHomeModel> {
//        Coroutines.main {
//            try {
//                _isViewLoading.postValue(true)
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GET_ASSET_BY_NAME)
//                inputParam.addProperty(Constant.REQUEST_NAME, Constant.REQUEST_HERO_SECTION_VIDEO_SHORT)
//                val apiResponse = repository.callCarousalImages(inputParam)
//                _isViewLoading.postValue(false)
//                _videoUrl.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _videoUrl
//    }
//
//
//    fun callMainCategoryList(): LiveData<CategoriesModel> {
//        Coroutines.main {
//            try {
//                _isViewLoading.postValue(true)
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_MAIN_CATEGORY)
//                val apiResponse = repository.callMainCategoryList(inputParam)
//                _isViewLoading.postValue(false)
//                _categories.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _categories
//    }
//
//    fun callBeauty(): LiveData<ProductListModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_CATEGORY_ID, Constant.KEY_FOR_BEAUTY)
//                inputParam.addProperty(Constant.REQUEST_MODE_1, "")
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callBeauty(inputParam)
//                if(apiResponse.data.size > 0) {
//                    for (i in apiResponse.data.indices) {
//                        apiResponse.data.get(i).usedFor = Constant.KEY_FOR_BEAUTY.toString()
//                    }
//                }
//                _isViewLoading.postValue(false)
//                _homeBeauty.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _homeBeauty
//    }
//
//    fun callFurniture(): LiveData<ProductListModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_CATEGORY_ID, Constant.KEY_FOR_FURNITURE)
//                inputParam.addProperty(Constant.REQUEST_MODE_1, "")
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callFurniture(inputParam)
//                if(apiResponse.data.size > 0) {
//                    for (i in apiResponse.data.indices) {
//                        apiResponse.data.get(i).usedFor = Constant.KEY_FOR_FURNITURE.toString()
//                    }
//                }
//                _isViewLoading.postValue(false)
//                _homeFurniture.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _homeFurniture
//    }
//
//    fun callHomeDecoration(): LiveData<ProductListModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_CATEGORY_ID, Constant.KEY_FOR_HOMEDECORATION)
//                inputParam.addProperty(Constant.REQUEST_MODE_1, "")
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callHomeDecoration(inputParam)
//                if(apiResponse.data.size > 0) {
//                    for (i in apiResponse.data.indices) {
//                        apiResponse.data.get(i).usedFor = Constant.KEY_FOR_HOMEDECORATION.toString()
//                    }
//                }
//                _isViewLoading.postValue(false)
//                _homeDecoration.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _homeDecoration
//    }
//
//    fun callAbout(): LiveData<AboutModel> {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GET_ASSET_BY_NAME)
//                inputParam.addProperty(Constant.REQUEST_NAME, Constant.REQUEST_ABOUTSUS)
//                _isViewLoading.postValue(true)
//                val apiResponse = repository.callAbout(inputParam)
//                _isViewLoading.postValue(false)
//                 _aboutpage.postValue(apiResponse)
//            } catch (e: ApiExceptions) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(e.message)
//            }
//        }
//        return _aboutpage
//    }
//
//    fun callAddRemoveFavourite(productid: Int,isdeleted: Int) {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_PRODUCT_ID, productid)
//                inputParam.addProperty(Constant.REQUEST_BUYERID, prefUtils.getUserId())
//                inputParam.addProperty(Constant.REQUEST_IS_DELETED, isdeleted)
//                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_INSERT_FAVOURITE)
//                inputParam.addProperty(Constant.REQUEST_CREATED_BY, "1")
//                val apiResponse = repository.callAddRemoveFavourite(inputParam)
//                application.toast(apiResponse.message)
//            } catch (e: ApiExceptions) {
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _onMessageError.postValue(e.message)
//            }
//        }
//    }
//
//    fun onSearchListner(s: CharSequence) {
//        if(s.toString().length > 2 ) {
//            callSearchAutoComplete(s.toString())
//        } else {
//            //Here we added blank list
//            val data: List<SearchAutoCompleteModel.Data> = listOf()
//            _searchAutoComplete.postValue(data)
//        }
//    }
//
//    fun callSearchAutoComplete(searchedData: String) {
//        Coroutines.main {
//            try {
//                val inputParam = JsonObject()
//                inputParam.addProperty(Constant.REQUEST_SEARCH_BAR, searchedData)
//                val apiResponse = repository.callSearchAutoComplete(inputParam)
//                if(apiResponse.status) {
//                    if(apiResponse.data.size > 0) {
//                        _searchAutoComplete.postValue(apiResponse.data)
//                    } else {
//                        //Here we added blank list
////                        val data: List<SearchAutoCompleteModel.Data> = listOf()
////                        _searchAutoComplete.postValue(data.get(0))
//                    }
//                }
//            } catch (e: ApiExceptions) {
//                _onMessageError.postValue(e.message)
//            } catch (e: NoInternetException) {
//                _onMessageError.postValue(e.message)
//            }
//        }
//    }

}