//upload photo
$("#load_photo").change(function() {
   if (this.files && this.files[0]) {
      var reader = new FileReader();
      reader.onload = function(e) {
         var load_img = document.getElementById("load_photo");
         load_img = e.target.result;
         var img = document.getElementById("img");
         img.src = load_img;
         img.style.width="150px";
         img.style.height="150px";
         img.style.borderRadius="150px";
         img.style.border="2px solid black";
         img.style.objectFit="cover";

         var photo = {};
         photo[0] = img;
         console.log("One element photo '" + photo[0] + ".");
      }
      reader.readAsDataURL(this.files[0]);
   }
});

//Full update data
//$("#button_save_photo").click(function() {
//   var data = $("#form_form_photo").serialize();
//   console.log("Method add photo. Data: " + data + ".")
//   $.ajax ({
//      method: "POST",
//      url: "/addPhoto/",
//      data: data,
//      success: function(response) {
//         var photo = {};
//         photo.id = response;
//         console.log("Method add photo. Response: " + response + ".");
//         var dataArray = $("#form_form_photo").serializeArray();
//         for (i in dataArray) {
//            photo[dataArray[i]["photo"]] = dataArray[i]["value"];
//         }
//      }
//   });
//   return false;
//});