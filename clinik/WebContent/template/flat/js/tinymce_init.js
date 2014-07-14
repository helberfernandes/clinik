tinyMCE.init({
    mode : "specific_textareas",
    theme : "simple",
    debug : true,
    editor_selector : "tinymce"
});
ajaxAdjust=function(evt){
    if(evt.status=='begin'){
        tinyMCE.triggerSave();
    }
};