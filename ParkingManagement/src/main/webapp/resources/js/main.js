/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function deleteParking(endpoint, parkingId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`parking${parkingId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteStatus(endpoint, statusId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`status${statusId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteUser(endpoint, userId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`user${userId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteRating(endpoint, ratingId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`rating${ratingId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteComment(endpoint, commentId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`comment${commentId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteOrderCancel(endpoint, orderCancelId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`orderCancel${orderCancelId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}
