import { useState } from "react";

export default function Calculator() {
  
  const [shown, setShown] = useState("");
  const [hidden, setHidden] = useState(0);
  const [operator, setOperator] = useState("");
  const numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  const operators = ["+", "-", "*", "/", "="]

  return (
    <>
      <div>
        {shown}
        <br />
        {hidden}
      </div>
      <input type="text" value={shown} readOnly />
      <br />
      <hr />
      <hr />

      {numbers.map((n) => (
        <input
          type="button"
          value={n}
          onClick={(e) => {
            const element = e.target as HTMLInputElement;
            setShown(shown + `${element.value}`);
          }}
        />
      ))}

      {
        operators.map((o) => (
          <button
            onClick={() => {
              switch (operator) {
                case "+":
                  setHidden(hidden + parseFloat(shown));
                  break;
                case "-":
                  setHidden(hidden - parseFloat(shown));
                  break;
                case "*":
                  setHidden(hidden * parseFloat(shown));
                  break;
                case "/":
                  setHidden(hidden / parseFloat(shown));
                  break;
                default:
                  setHidden(parseFloat(shown));
              }
              setShown("");
              setOperator(o);
            }}
          >
          {o}
          </button>
        ))
      }
    </>
  );
}