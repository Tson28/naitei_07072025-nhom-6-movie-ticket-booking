function filterStatus(value) {
        const url = new URL(window.location.href);
        url.searchParams.set('status', value); // cập nhật param status
        url.searchParams.set('page', 0);       // reset về trang 1
        window.location.href = url.toString();
}
async function showDetail(id) {
        const modalEl = document.getElementById("detailModal");
        const modal = bootstrap.Modal.getOrCreateInstance(modalEl);

        const els = {
                name: document.getElementById("modalCinemaName"),
                address: document.getElementById("modalAddress"),
                description: document.getElementById("modalDescription"),
                user: document.getElementById("modalUser"),
                email: document.getElementById("modalEmail"),
                date: document.getElementById("modalDate"),
                status: document.getElementById("modalStatus"),
                actions: document.getElementById("modalActions"),
                errorMsg: document.getElementById("modalErrorMsg")
        };

        Object.values(els).forEach(el => {
                if (el && el !== els.actions && el !== els.errorMsg) el.textContent = "Đang tải...";
        });
        els.actions.innerHTML = "";
        els.errorMsg.classList.add("d-none");
        els.errorMsg.textContent = "";
        modal.show();

        try {
                const res = await fetch(`/admin/request_cinemas/${id}`, {
                        headers: { "Accept": "application/json" }
                });
                if (!res.ok) throw new Error(`HTTP ${res.status}`);

                const ct = res.headers.get("content-type") || "";
                if (!ct.includes("application/json")) throw new Error("Content-Type không phải JSON");

                const data = await res.json();
                if (!data || typeof data !== "object") throw new Error("Payload không hợp lệ");

                const safe = v => (v === null || v === undefined || v === "") ? "-" : v;

                els.name.textContent = safe(data.cinemaName);
                els.address.textContent = safe(data.address);
                els.description.textContent = safe(data.description);
                els.user.textContent = safe(data.userName);
                els.email.textContent = safe(data.email);
                els.date.textContent = data.sentDate ? new Date(data.sentDate).toLocaleString() : "-";
                els.status.textContent = safe(data.status);

                els.actions.innerHTML = "";
                if ((data.status || "").toUpperCase() === "PENDING") {
                        els.actions.innerHTML = `
                <button class="btn btn-success" onclick="approve(${id})">Xác nhận</button>
                <button class="btn btn-danger" onclick="reject(${id})">Từ chối</button>
            `;
                }
        } catch (err) {
                console.error(err);

                els.errorMsg.classList.remove("d-none");
                els.errorMsg.textContent = "Không thể tải dữ liệu. Vui lòng thử lại.";

                Object.values(els).forEach(el => {
                        if (el && el !== els.actions && el !== els.errorMsg) el.textContent = "-";
                });

                els.actions.innerHTML = `
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="button" class="btn btn-outline-primary" onclick="showDetail(${id})">Thử lại</button>
                `;
        }
}
