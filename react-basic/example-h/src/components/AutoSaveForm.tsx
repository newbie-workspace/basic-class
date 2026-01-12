import { useEffect, useState } from "react";

export default function AutoSaveForm() {
    const [formData, setFormData] = useState(
        () => localStorage.getItem("savedFormData") || ""
    );

    useEffect(
        () => {
        const timeoutId = setTimeout(() => {
            localStorage.setItem("savedFormData", formData);
        }, 1000);
        return () => clearTimeout(timeoutId);
        }, 
    [formData]); //formData 가 변경되면 첫 번째 함수 실행

    return (
        <>
        <textarea
            value={formData}
            onChange={(e) => setFormData(e.target.value)}
            placeholder="입력한 내용을 자동으로 저장합니다."
        />
        <br />
        <button onClick={ () => localStorage.clear()}>데이터 지우기</button>
        </>
    );
}