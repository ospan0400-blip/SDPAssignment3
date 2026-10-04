# Assignment 3 - Bridge Pattern

Name: Omar Zhakiya
Group: SE-2529
Topic: A - Drawing
Base commit hash: 35b5c0a

## Role map

| Role | Class | Source |
|---|---|---|
| Abstraction | `Shape` | `src/Shape.java` |
| Refined Abstraction A1 | `Circle` | `src/Circle.java` |
| Refined Abstraction A2 | `Square` | `src/Square.java` |
| Implementor | `Renderer` | `src/Renderer.java` |
| Initial Implementation I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| Initial Implementation I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| Extension I3 | `AsciiRenderer` | `src/AsciiRenderer.java` |
| Client | `Main` | `src/Main.java` |

The Bridge field is `renderer` in `Shape`. The public `execute()` operation is declared by `Shape` and implemented by `Circle` and `Square`. Runtime replacement is provided by `Shape.setImplementation(Renderer renderer)`. The T5 runtime-switch check is in `Main.checkRuntimeSwitch()`.

## Bridge mapping

The abstraction hierarchy varies by shape: `Shape -> Circle / Square`. The implementation hierarchy varies by rendering technology: `Renderer -> VectorRenderer / RasterRenderer / AsciiRenderer`. The two dimensions are linked by composition through the `Renderer` reference stored by `Shape`.

## Build and run

From the project root:

```text
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected T1-T7 outcomes

- T1: `Circle + VectorRenderer` -> `VECTOR circle radius=2`
- T2: `Circle + RasterRenderer` -> `RASTER circle radius=2`
- T3: `Square + VectorRenderer` -> `VECTOR square side=3`
- T4: `Square + RasterRenderer` -> `RASTER square side=3`
- T5: the same `Circle` object is reused; ID and radius remain unchanged; result changes from Vector to Raster after `setImplementation(...)`
- T6: `Circle + AsciiRenderer` -> `ASCII circle radius=2`
- T7: `Square + AsciiRenderer` -> `ASCII square side=3`

The submitted demo should finish with `SUMMARY: 7/7 PASS`.

## Extension

Base commit: 1ca27e714dd6b7a95f87271d97e388bd94be72e9
Extension commit: 39b1f33b5b7bfdd7b96a5e81cfb81afa35d11d8f

The base commit contains the working two-by-two solution and runtime switch using I1 and I2. The extension commit adds `AsciiRenderer` and updates `Main` for T6-T7. The existing abstraction classes, `Renderer`, `VectorRenderer`, and `RasterRenderer` are unchanged in the extension.

