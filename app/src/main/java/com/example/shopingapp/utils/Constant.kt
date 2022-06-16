package com.example.shopingapp.utils

/**
 * Class Contains All the Constant Values which will be used through out App
 */
class Constant {

    companion object {

        const val ROOT_FOLDER_NAME = "TaskApp"

        //Common keys
        const val CHECK_INTENET_TITLE = "No internet"
        const val CHECK_INTERNET = "Please check your internet connection"
        const val DEFAULT_SERVER_ERROR = "Something went wrong on server side. Please try again."
        const val APP_PREFERENCES = "app_preferences"
        const val HINT_VIDEO_PREFERENCE = "hint_video_preference"
        const val SOCKET_TIMEOUT_EXCEPTIONS = "Socket Timeout Exception"
        const val CONNECTION_TIMEOUT_EXCEPTIONS = "Connection Timeout Exception"
        const val HEADER_AUTHORIZATION = "Authorization"
        const val TOKEN = "Token"
        const val SUCCESS_CODE = 200
        const val UNAUTHORIZED_CODE = 401
        const val INTERNAL_SERVER_ERROR_CODE = 500
        const val NO_DATA_FOUND_CODE = 404
        const val METHOD_NOT_ALLOW = 405
        const val NON_AUTHORITATIVE_INFORMATION = 203
        const val RESPONSE_MESSAGE = "message"
        const val LOADING = "loading"
        const val SUCCESS = "success"
        const val ERROR = "error"
        const val ABOUT_US_URL = "http://buyamia-buyer.fahm-technologies.com/aboutus"

        @JvmField
        var CURRENT_LIST_POSITION = 0

        const val KEY_BEST_SELLER = -1
        const val KEY_CATEGORY = 0

        const val REQUEST_CATEGORY_ID = "categoryid"
        const val KEY_HOME_AND_LIVING = 7
        const val KEY_ART_AND_ANTIQUE = 1
        const val REQUEST_SUBCATEGORY_ID = "subcategoryid"
        const val REQUEST_PRODUCT_ID = "productid"
        const val REQUEST_MAIN_CATEGORY = "getallmaincategory"
        const val REQUEST_MODE = "mode"
        const val REQUEST_IS_DELETED = "isdeleted"
        const val REQUEST_MODE_1 = "mode1"
        const val REQUEST_INSERT_FAVOURITE = "InsertFavourite"
        const val REQUEST_PRODUCT_BY_SELLER = "productbyseller"
        const val REQUEST_SELLER_ID = "sellerid"
        const val REQUEST_INSERT_CART = "InsertCart"
        const val REQUEST_QUOTE_REF_ID = "quoterefid"
        const val REQUEST_RATE = "rate"
        const val KEY_FOR_BEAUTY = 2
        const val KEY_FOR_FURNITURE = 3
        const val KEY_FOR_HOMEDECORATION = 4
        const val kEY_FROM_SEARCH = "search"
        const val kEY_FROM_WISH_LIST = "wishlist"
        const val KEY_FROM = "from"
        const val KEY_TO = "to"
        const val KEY_PRICE = "price"
        const val REQUEST_GETCART = "GetCart"
        const val REQUEST_BUYERID = "buyerid"
        const val REQUEST_VALUE = "1"
        const val REQUEST_ORDER_QTY = "orderqty"
        const val REQUEST_CREATED_BY = "createdby"
        const val REQUEST_UPDATED_BY = "updatedby"
        const val KEY_VARIANT = "variant"
        const val KEY_VARIANT_OPTION = "variantoption"
        const val REQUEST_DELETECART = "DeleteCart"
        const val REQUEST_CARTID = "cartid"
        const val REQUEST_TARGET_LANG = "targetlang"
        const val REQUEST_QUERY = "query"
        const val REQUEST_INQUIRYID = "inquiryid"
        const val REQUEST_ORDERID = "ordid"
        const val REQUEST_GETBUYERINQUIRYLIST = "getbuyerinquirylist"
        const val REQUEST_GETSHIPPINGINQUIRYDETAILS = "getshippinginquirydetails"

        const val REQUEST_GETBUYERORDERLIST = "getbuyerorderlist"
        const val REQUEST_GETBUYERINQUIRYDETAILS = "getinquirydetailsbyid"
        const val REQUEST_GETORDERDETAILSBYID = "getorderdetailsbyid"

        const val REQUEST_INSERTBUYERINQUIRY = "insertbuyerinquiry"
        const val REQUEST_CUSTOMMAZATION_DES = "customdescrb"
        const val REQUEST_CUSTOMMAZATION_DES_KEY = "yes"
        const val REQUEST_DESTADDR1 = "destaddr1"
        const val REQUEST_DESTADDR1_KEY = "Makarba"
        const val REQUEST_DESTADDR2 = "destaddr1"
        const val REQUEST_DESTADDR2_KEY = "Sarkhej"
        const val REQUEST_DESTCITY = "destcity"
        const val REQUEST_DESTCITY_KEY = "Ahmd"
        const val REQUEST_DESTCOUNTRY ="destcountry"
        const val REQUEST_DESTCOUNTRY_KEY ="India"
        const val REQUEST_DESTZIP="destzip"

        const val REQUEST_FWCOMPANY="fwcompany"
        const val REQUEST_FWCOMPANY_KEY ="Super Furniture"

        const val REQUEST_FWCONTACTNO="fwcontactno"
        const val REQUEST_FWEMAIL="fwemail"
        const val REQUEST_FWEMAIL_KEY="pal@gmail.com"
        const val REQUEST_FWFIRSTNAME="fwfirstname"
        const val REQUEST_FWFIRSTNAME_KEY="Zahid"
        const val REQUEST_FWLASTNAME="fwlastname"
        const val REQUEST_FWLASTNAME_KEY="Palsania"
        const val REQUEST_ISCUSTOMAIZATION="iscustom"

        const val REQUEST_ISQC="isqc"
        const val REQUEST_ISQC_KEY="B"
        const val REQUEST_ISSHIP="isship"
        const val REQUEST_ISPRODUCT="isproduct"
        const val REQUEST_FALSE="false"
        const val REQUEST_ISSHIP_BY_BUYAMIA_KEY = "B"
        const val REQUEST_ISSHIP_BY_SELLER_KEY = "S"
        const val REQUEST_PACKINGDESCRB="packingdescrb"
        const val REQUEST_PACKINGDESCRB_KEY="yes"
        const val REQUEST_PRODUCTID="productid"

        const val REQUEST_QCDESCRB="qcdescrb"
        const val REQUEST_QCDESCRB_KEY="yes"
        const val REQUEST_QUANTITY="quantity"


        const val REQUEST_SELLERID="sellerid"
        const val REQUEST_SHIPDESCRB="shipdescrb"
        const val REQUEST_SHIPDESCRB_KEY="yes"
        const val REQUEST_SHIPNOTE="shipnote"
        const val REQUEST_SHIPNOTE_KEY="no other requirement"
        const val REQUEST_VARIANTINFO="variantinfo"
        const val REQUEST_VARIANTINFO_KEY=""
        const val REQUEST_ATTACHMENTS="attachments"
        const val REQUEST_ATTACHMENTS_KEY="[{\"filename\":\"Vectorfurniture.png\",\"filesize\":\"23.82\",\"filetype\":\"image/png\",\"fileurl\":\"https://buyamia-seller-media.s3.ap-south-1.amazonaws.com/Images/inquiryattachment_/profile/vectorfurniture.png\"}]"


        const val REQUEST_LOGIN_MODE_BY_EMAIL = "loginuserbyemail"
        const val REQUEST_EMAILID = "emailid"
        const val REQUEST_EMAILID_TEST = "test1@gmail.com"
        const val REQUEST_PASSWORD = "password"
        const val REQUEST_PASSWORD_TEST = "test1@1234"
        const val REQUEST_SIGNUPBUYERRAGISTER = "buyerregisterbyemail"
        const val REQUEST_FIRSTNAME = "firstname"
        const val REQUEST_LASTNAME = "lastname"


        const val REQUEST_PRODUCT_BY_DISPLAY_FLAGS = "Productbydisplayflags"
        const val REQUEST_GET_PRODUCT_BY_CATEGORY_AND_SECTION = "GetProductByCategoryAndSection"
        const val REQUEST_GET_SUB_CATEGORY_BY_MAIN_CATEGORY = "getsubcategorybymaincategory"
        const val REQUEST_SECTION = "section"
        const val REQUEST_SEARCHBAR = "searchbar"

        const val REQUEST_READY_TO_SHIP = "readytoship"
        const val REQUEST_MOST_POPULAR = "mostpopular"
        const val REQUEST_DISPLAYFLAGS = "displayflags"
        const val REQUEST_BEST_SELLER = "BS"
        const val REQUEST_UNIQUE_PRODUCT = "UP"
        const val REQUEST_HOME_MADE = "HM"
        const val REQUEST_DL = "DL"
        const val REQUEST_WL = "WL"
        const val REQUEST_RTS = "RTS"
        const val REQUEST_MEET_THE_MAKER = "meetthemaker"
        const val KEY_MORE_FROM_THIS_MAKER = "more_from_this_make"
        const val KEY_SUB_CATEGORY = "sub_category"
        const val REQUEST_ABOUTSUS = "aboutus"
        const val REQUEST_NAME = "name"
        const val REQUEST_GET_ASSET_BY_NAME = "getassetbyname"
        const val REQUEST_CAROUSAL_IMAGES = "carousalimages"
        const val REQUEST_YOU_MAY_LIKE_THIS = "YMLT"
        const val REQUEST_HERO_SECTION_VIDEO_SHORT = "herosectionvideoshort"
        const val REQUEST_GET_SEARCH_PRODUCT = "GetSearchProduct"
        const val REQUEST_SEARCH_BAR = "searchbar"
        const val KEY_ASSET_CODE = "assetcode"
        const val KEY_DESIGN_LABLES = "designer labels"
        const val KEY_CUSTOMIZE_WHITE_LABLES = "Customize & White Label"
        const val KEY_RAW_MATERIALS = "Raw Materials"
        const val KEY_LOGIN_FOR_CART = "login for cart"
        const val KEY_LOGIN_FOR_ADD_TO_CART = "login for add to cart"
        const val KEY_LOGIN_FOR_FAVOURITE = "login for favourite"
        const val KEY = "key"
        const val REQUEST_GET_FAVOURITE_LIST = "getfavouritelist"

        const val REQUEST_HOME_DACORATON = "HD"
//        const val REQUEST_GET_PRODUCTDETAILS_BYPRODUCT_ID = "getproductdetailsbyproductid"

        //Product Specification screen
        const val KEY_PLACE_OF_ORIGIN = "place_of_origin"
        const val KEY_CERTIFICATES = "certificates"
        const val KEY_BUYER_PROTECTIONS = "buyer_protection"
        const val KEY_BRAND = "brand"
        const val KEY_MODEL = "model"
        const val KEY_DIMENSION = "dimension"
        const val KEY_BUYER_TYPE = "buyer_type"
        const val KEY_OCCASION = "occasion"
        const val KEY_KEY_FEATURE = "key_feature"
        const val KEY_APPLICATION = "applications"
        const val KEY_WHITE_LABELLING = "white_label"
        const val KEY_MAINTANCE_INSTRUCTION = "maintaincin_instruction"
        const val KEY_SHIPPING_OPTIONS = "shipping_option"
        const val KEY_PACKAGE_DIMENSION = "packaging_dimension"
        const val REQUEST_VARIANT_NAME_1 = "variantname1"
        const val REQUEST_VARIANT_NAME_2 = "variantname2"
        const val REQUEST_VARIANT_VALUE_1 = "variantvalue1"
        const val REQUEST_VARIANT_VALUE_2 = "variantvalue2"
        const val kEY_BEST_SELLER_VIEW_ALL = "Best seller"
        const val kEY_UNIQUE_PRODUCTS_VIEW_ALL = "Unique products"
        const val KEY_HOME_MADE_VIEW_ALL = "Home made"
        const val KEY_BEAUTY_VIEW_ALL = "Beauty"
        const val KEY_FURNITURE_VIEW_ALL = "Furniture"
        const val KEY_HOME_DECORATION = "Home decoration"
        const val KEY_MORE_FROM_THIS_MAKERS = "More from this maker"
        const val KEY_SIMILAR_ITEMS= "Similar items"

        //Company policy
        const val KEY_REFUND_IN_DAYS = "refundindays"
        const val KEY_REFUND_POLICY = "refundpolicy"

        //Company Inside
        const val KEY_COMPANY_NAME = "company_name"
        const val KEY_COMPANY_DESCRIPTION = "company_description"
        const val KEY_VIDEO_PLAYING_URL = "video_playing_url"

        //fileupload InquiryList

        const val REQUEST_FILE_TITLE = "filetitle"
        const val REQUEST_FILE_DESCR = "filedescr"
        const val REQUEST_FILE_TYPE = "filetype"
        const val REQUEST_FILE_EXT = "fileext"
        const val REQUEST_FILE_SIZE = "filesize"
        const val REUQEST_UPLOAD_TYPE = "uploadtype"
        const val REQUEST_IMAGE = "Image"
        const val REQUEST_FILE = "file"

        //Order
        const val REQUEST_CREATEORDERBYCART = "createorderbycart"
        const val REQUEST_TRANSACTIONID = "transactionid"
        const val REQUEST_PAYMENTMETHOD = "pymtmethod"
        const val REQUEST_PAYMENTMETHOD_KEY = "L"
        const val REQUEST_CREATEDBY = "createdby"



    }
}