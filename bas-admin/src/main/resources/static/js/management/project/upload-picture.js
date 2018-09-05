var DaveDropzone = function () {

    return {
        //main function to initiate the module
        init: function () {  
            Dropzone.options.dropzone = {
            	maxFiles:1,
                dictDefaultMessage: "",
                init: function() {
                    this.on("addedfile", function(file) {
                        // Create the remove button
                        var removeButton = Dropzone.createElement("<a href='javascript:;'' class='btn red btn-sm btn-block'>Remove</a>");
                        
                        // Capture the Dropzone instance as closure.
                        var _this = this;

                        // Listen to the click event
                        removeButton.addEventListener("click", function(e) {
                          // Make sure the button click doesn't submit the form:
                          e.preventDefault();
                          e.stopPropagation();

                          // Remove the file preview.
                          _this.removeFile(file);
                          // If you want to the delete the file on the server as well,
                          // you can do the AJAX request here.
                        });

                        // Add the button to the file preview element.
                        file.previewElement.appendChild(removeButton);
                    });
                    
                    this.on("success", function(file,data) {
//                        this.removeFile(file);
                        $("#pictureId").val(data.id);
                        $('#upload-picture-modal .alert-danger').hide();
                    });
                    this.on("error", function(file,data) {
                        console.log("File " + file.name + "uploaded error");
                        this.removeFile(file);
                    });                    
                }            
            }
        }
    };
}();

jQuery(document).ready(function() {    
   DaveDropzone.init();
});