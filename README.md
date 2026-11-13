# CSA09-192521452-Assignment3 — Java CO3
Student: Anjali Oviya | Register: 192521452 | Java target: 21

This implementation workspace covers Q1–Q7 from the supplied Assignment 3 PDF. Each Task folder is independently compilable. Execute every task yourself, capture genuine screenshots, and record actual observations before submission.

## Compile and run from repository root
```bash
mkdir -p out
javac --release 21 -d out Task01/*.java && java -cp out AtmDemo
javac --release 21 -d out Task02/*.java && java -cp out StorageDemo
javac --release 21 -d out Task03/*.java && java -cp out SalesReportDemo
javac --release 21 -d out Task04/*.java && java -cp out ScannerStations
javac --release 21 -d out Task05/*.java && java -cp out SeatBooking
javac --release 21 -d out Task06/*.java && java -cp out TokenCounter
javac --release 21 -d out Task07/*.java && java -cp out ResultProcessor
```
For Q3/Q7 run from the repository root because they use `data/` paths. For Q7's full scale experiment use `java -cp out ResultProcessor 10000`.

## Important assignment evidence
The PDF requires both partners to execute all questions individually, one progressive Git commit per task, Q1 five test paths plus a stack trace and catch-order experiment, Q3 debugger/breakpoint evidence, Q4 ten-run/priority/daemon observations, Q5 ten unsafe race runs and synchronized timing, Q7 pool measurements 1/2/4/8 on 10,000 files, raw data, screenshots, individual contribution table, and faculty GitHub link. The code does not fabricate personal debugging or execution evidence. Add your actual outputs under `outputs/` and complete the report after running.
