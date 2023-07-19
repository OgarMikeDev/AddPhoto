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
      }
      reader.readAsDataURL(this.files[0]);
   }
});

//Full update data
$("#button_save_photo").click(function() {
   var data = $("#form_form_photo").serialize();
   $.ajax ({
      method: "POST",
      url: "/addPhoto/",
      data: data,
      success: function(response) {
         var photo = {};
         photo[[0]["photo"]] = document.getElementById("img").src;
         document.getElementById("text_form_photo").value = document.getElementById("img").src;
         console.log("Method treatment photo. One element form with data '" + photo[[0]["photo"]] +
         "'.")
      }
   });
   return false;
});