class App {
    static DOMAIN = location.origin;
    static BASER_URL = this.DOMAIN + "/api";

    static ERROR_400 = "Thao tác không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_401 = "Access Denied! Invalid credentials.";
    static ERROR_403 = "Access Denied! You are not authorized to perform this function.";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Lưu dữ liệu không thành công, vui lòng liên hệ quản trị hệ thống.";
    static SUCCESS_CREATED = "Successful data generation !";
    static SUCCESS_UPDATED = "Info update successful !";
    static AVATAR_UPDATED_SUCCESS = "Avatar update successful !";
    static SUCCESS_DELETED = "Delete blog successfully !";


    static SweetAleart = class {
        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 4000
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
                timer: 4000
            })
        }

        static showSuspendedConfirmAlert() {
            return Swal.fire({
                title: 'Are you sure?',
                text: "Are you sure you want to delete the selected data?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: "Yes, delete it!",
            })
        }
    }

    static IziToast = class {
        static showSuccessAlert(title) {
            iziToast.success({
                title: 'SUCCESS',
                position: 'topRight',
                timeout: 1000,
                message: title
            })
        }

        static showSuccessAlertBottom(title) {
            iziToast.success({
                title: 'SUCCESS',
                position: 'bottomLeft',
                timeout: 1000,
                message: title
            })
        }

        static showErrorAlert(title) {
            iziToast.error({
                title: 'ERROR',
                position: 'topRight',
                timeout: 4000,
                message: title
            })
        }

        static showErrorAlertBottom(title) {
            iziToast.error({
                title: 'ERROR',
                position: 'bottomLeft',
                timeout: 4000,
                message: title
            })
        }

    }

    // static formatNumber() {
    //     $(".num-space").number(true, 0, ',', ' ');
    //     $(".num-point").number(true, 0, ',', '.');
    //     $(".num-comma").number(true, 0, ',', ',');
    // }
    //
    // static formatNumberSpace(x) {
    //     if (x == null) {
    //         return x;
    //     }
    //     return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    // }
    //
    // static removeFormatNumberSpace(x) {
    //     if (x == null) {
    //         return x;
    //     }
    //     return x.toString().replace(/ /g, "")
    // }
    //
    // static formatTooltip() {
    //     $('[data-toggle="tooltip"]').tooltip();
    // }


    renderInputTechSpecForm

    static renderInputTechSpecForm(obj) {
        let str = `
            <div class="form-group row mb-4">
                <label class="col-form-label col-lg-2">${obj.explanation} : </label>
                <div class="col-lg-10">
                    ${obj.multiline
                    ? `<textarea class="form-control" id="${obj.name}" data-name="${obj.name}" data-explanation="${obj.explanation}" rows="1" style="resize: none;"></textarea>`
                    : `<input type="text" class="form-control" id="${obj.name}" data-name="${obj.name}" data-explanation="${obj.explanation}">`
                    }
                </div>
            </div>
        `;

        return str;
    }

    static renderProduct(obj) {
        let strImg = "";

        $.each(obj.fileUrls, (key, value) => {
            strImg += `
                <img src="${value}" alt="product-img" title="product-img" class="avatar-md"> 
              `;
            return false;
        })

        let str = `
            <tr>
                <td>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="customCheck--${obj.id}">
                        <label class="custom-control-label" for="customCheck--${obj.id}">&nbsp;</label>
                    </div>
                </td>
                <td>
                    ${strImg}
                </td>
                <td data-bs-toggle="tooltip" title="Hooray!">${obj.title}</td>
                <td>
                    ${
                        obj.businessStatus != "Ngừng Kinh Doanh" ? `<span class="badge badge-pill badge-soft-success font-size-12">${obj.businessStatus}</span>` : `<span class="badge badge-pill badge-soft-danger font-size-12">${obj.businessStatus}</span>`
                    }
                </td>
                <td>
                    <a href="/products/${obj.slug}" class="btn btn-primary btn-sm btn-rounded">View Details</a>
                </td>
                <td>
                    <a href="/products/update/${obj.slug}" class="mr-3 text-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"><i class="mdi mdi-pencil font-size-18"></i></a>
                </td>
            </tr>
        `;

        return str;
    }

}