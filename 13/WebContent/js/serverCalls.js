$("button.createProduct")
	.click(
		function() {

			var name = $("form.createProduct input.productName").val();
			var description = $("form.createProduct input.productDescription").val();
			var price = $("form.createProduct input.productPrice").val();

			var product = {
				name: name,
				description: description,
				price: price
			};
			//add validation
			$.post("product", product,
				function(data) {
					if (data == 'Success') {
						alert('Success');
					}
				});

		});


$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");


	$.post("bucket", { 'productId': productId },
		function(data) {
			if (data == 'Success') {
				$("[data-dismiss=modal]").trigger({ type: "click" });
				alert('Success');
			}
		});
});